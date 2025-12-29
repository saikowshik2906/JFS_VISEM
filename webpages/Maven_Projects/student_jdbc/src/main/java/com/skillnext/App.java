package com.skillnext;

import java.util.List;
import java.util.Scanner;

public class App {
    private static final StudentDAO studentDao = new StudentDAO();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        
        System.out.println("--- Welcome to Student JDBC Management System ---");
        
        do {
            displayMenu();
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                
                switch (choice) {
                    case 1:
                        insertStudentInput();
                        break;
                    case 2:
                        deleteStudentInput();
                        break;
                    case 3:
                        updateStudentInput();
                        break;
                    case 4:
                        showAllStudents();
                        break;
                    case 0:
                        System.out.println("\nExiting application. Goodbye!");
                        break;
                    default:
                        System.out.println("\nInvalid choice. Please enter a number from the menu.");
                }
            } else {
                System.out.println("\nInvalid input. Please enter a number.");
                scanner.nextLine(); // Consume the invalid input
                choice = -1; // Set to invalid choice to continue loop
            }
            
        } while (choice != 0);
        
        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("\n=============================================");
        System.out.println("  STUDENT MANAGEMENT MENU");
        System.out.println("=============================================");
        System.out.println("1. Insert New Student (C - Create)");
        System.out.println("2. Delete Student by ID (D - Delete)");
        System.out.println("3. Update Student Details (U - Update)");
        System.out.println("4. Show All Students (R - Read)");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }
    
    // --- 1. INSERT Operation ---
    private static void insertStudentInput() {
        System.out.println("\n--- INSERT NEW STUDENT ---");
        
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter Semester: ");
        int semester = getIntInput();
        
        System.out.print("Enter Department: ");
        String dept = scanner.nextLine();
        
        Student newStudent = new Student(name, semester, dept);
        
        if (studentDao.insertStudent(newStudent)) {
            System.out.println("✅ Student '" + name + "' inserted successfully!");
        } else {
            System.out.println("❌ Failed to insert student.");
        }
    }
    
    // --- 2. DELETE Operation ---
    private static void deleteStudentInput() {
        System.out.println("\n--- DELETE STUDENT ---");
        System.out.print("Enter Student ID to Delete: ");
        int id = getIntInput();
        
        if (studentDao.deleteStudent(id)) {
            System.out.println("✅ Student with ID " + id + " deleted successfully!");
        } else {
            System.out.println("❌ Failed to delete student with ID " + id + ". (Maybe ID does not exist)");
        }
    }

    // --- 3. UPDATE Operation ---
    private static void updateStudentInput() {
        System.out.println("\n--- UPDATE STUDENT ---");
        System.out.print("Enter Student ID to Update: ");
        int id = getIntInput();
        
        System.out.print("Enter New Name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter New Semester: ");
        int semester = getIntInput();
        
        System.out.print("Enter New Department: ");
        String dept = scanner.nextLine();
        
        Student studentToUpdate = new Student(id, name, semester, dept);
        
        if (studentDao.updateStudent(studentToUpdate)) {
            System.out.println("✅ Student with ID " + id + " updated successfully!");
        } else {
            System.out.println("❌ Failed to update student with ID " + id + ". (Maybe ID does not exist)");
        }
    }

    // --- 4. SHOW ALL Operation ---
    private static void showAllStudents() {
        System.out.println("\n--- ALL STUDENTS ---");
        List<Student> students = studentDao.showAllStudents();
        
        if (students.isEmpty()) {
            System.out.println("No students found in the database.");
        } else {
            students.forEach(System.out::println);
        }
    }
    
    // Helper method to handle integer input and error checking
    private static int getIntInput() {
        while (true) {
            if (scanner.hasNextInt()) {
                int input = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                return input;
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                System.out.print("Re-enter: ");
                scanner.nextLine(); // Consume the invalid input
            }
        }
    }
}