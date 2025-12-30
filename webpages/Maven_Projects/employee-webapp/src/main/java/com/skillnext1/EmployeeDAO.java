package com.skillnext1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import com.skillnext1.Employee;

public class EmployeeDAO {

    public static void save(Employee emp) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/skillnext_db",
                "root",
                ""
            );

            String sql = "INSERT INTO employee(name,email,salary) VALUES(?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, emp.getName());
            ps.setString(2, emp.getEmail());
            ps.setDouble(3, emp.getSalary());

            ps.executeUpdate();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Employee emp = new Employee();
        emp.setName("Test Employee");
        emp.setEmail("test@example.com");
        emp.setSalary(50000);
        
        save(emp);
        System.out.println("Employee saved successfully (Test Mode)");
    }
}
