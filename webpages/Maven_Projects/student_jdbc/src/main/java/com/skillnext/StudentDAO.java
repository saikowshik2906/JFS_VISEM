package com.skillnext;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    // Database connection details
    private static final String URL = "jdbc:mysql://localhost:3306/skillnext_db";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    
    // SQL Queries
    private static final String INSERT_STUDENT_SQL = 
        "INSERT INTO student_tb (name, semester, dept) VALUES (?, ?, ?)";
    private static final String SELECT_ALL_STUDENTS_SQL = 
        "SELECT * FROM student_tb";
    private static final String DELETE_STUDENT_SQL = 
        "DELETE FROM student_tb WHERE id = ?";
    private static final String UPDATE_STUDENT_SQL = 
        "UPDATE student_tb SET name = ?, semester = ?, dept = ? WHERE id = ?";
    
    // Helper method to establish connection
    private Connection getConnection() throws SQLException {
        // NOTE: In modern JDBC (since Java 6), Class.forName() is often not strictly
        // required for Type 4 drivers like MySQL Connector/J, but is good practice.
        // try {
        //     Class.forName("com.mysql.cj.jdbc.Driver");
        // } catch (ClassNotFoundException e) {
        //     System.err.println("MySQL JDBC Driver not found.");
        //     e.printStackTrace();
        // }
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
    
    /**
     * 1. Inserts a new student into the database.
     */
    public boolean insertStudent(Student student) {
        boolean rowInserted = false;
        // Use try-with-resources to ensure Connection and PreparedStatement are closed
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_STUDENT_SQL)) {
            
            preparedStatement.setString(1, student.getName());
            preparedStatement.setInt(2, student.getSemester());
            preparedStatement.setString(3, student.getDept());
            
            // executeUpdate returns the number of affected rows
            rowInserted = preparedStatement.executeUpdate() > 0;
            
        } catch (SQLException e) {
            System.err.println("SQL Exception during insertStudent:");
            e.printStackTrace();
        }
        return rowInserted;
    }

    /**
     * 2. Deletes a student from the database by ID.
     */
    public boolean deleteStudent(int id) {
        boolean rowDeleted = false;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_STUDENT_SQL)) {
            
            preparedStatement.setInt(1, id);
            
            rowDeleted = preparedStatement.executeUpdate() > 0;
            
        } catch (SQLException e) {
            System.err.println("SQL Exception during deleteStudent:");
            e.printStackTrace();
        }
        return rowDeleted;
    }

    /**
     * 3. Updates an existing student's details.
     */
    public boolean updateStudent(Student student) {
        boolean rowUpdated = false;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_STUDENT_SQL)) {
            
            preparedStatement.setString(1, student.getName());
            preparedStatement.setInt(2, student.getSemester());
            preparedStatement.setString(3, student.getDept());
            preparedStatement.setInt(4, student.getId()); // WHERE clause ID
            
            rowUpdated = preparedStatement.executeUpdate() > 0;
            
        } catch (SQLException e) {
            System.err.println("SQL Exception during updateStudent:");
            e.printStackTrace();
        }
        return rowUpdated;
    }

    /**
     * 4. Retrieves all students from the database.
     */
    public List<Student> showAllStudents() {
        List<Student> students = new ArrayList<>();
        
        try (Connection connection = getConnection();
             // Create a Statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_STUDENTS_SQL);
             // Execute the query
             ResultSet rs = preparedStatement.executeQuery()) {
            
            // Process the ResultSet object
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int semester = rs.getInt("semester");
                String dept = rs.getString("dept");
                
                students.add(new Student(id, name, semester, dept));
            }
            
        } catch (SQLException e) {
            System.err.println("SQL Exception during showAllStudents:");
            e.printStackTrace();
        }
        return students;
    }
}