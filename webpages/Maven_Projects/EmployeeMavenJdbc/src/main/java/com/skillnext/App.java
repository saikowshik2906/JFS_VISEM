package com.skillnext;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Scanner sc = new Scanner(System.in);

        // ---------- LOGIN ----------
        System.out.print("Username: ");
        String username = sc.next();

        System.out.print("Password: ");
        String password = sc.next();

        if (!LoginDAO.validate(username, password)) {
            System.out.println("Invalid credentials. Access denied.");
            return;
        }

        System.out.println("Login successful");

        int choice;

        do {
            // ---------- MENU ----------
            System.out.println("\n===== EMPLOYEE MENU =====");
            System.out.println("1. Insert Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. View Employee By ID");
            System.out.println("4. Update Employee");
            System.out.println("5. Delete Employee");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1: // INSERT
                    System.out.print("Employee Name: ");
                    String name = sc.next();

                    System.out.print("Department: ");
                    String dept = sc.next();

                    System.out.print("Salary: ");
                    double salary = sc.nextDouble();

                    EmployeeDAO.insertEmployee(name, dept, salary);
                    break;

                case 2: // READ ALL
                    EmployeeDAO.getAllEmployees();
                    break;

                case 3: // READ BY ID
                    System.out.print("Enter Employee ID: ");
                    int id = sc.nextInt();

                    EmployeeDAO.getEmployeeById(id);
                    break;

                case 4: // UPDATE
                    System.out.print("Enter Employee ID to Update: ");
                    int uid = sc.nextInt();

                    System.out.print("New Name: ");
                    String uname = sc.next();

                    System.out.print("New Department: ");
                    String udept = sc.next();

                    System.out.print("New Salary: ");
                    double usalary = sc.nextDouble();

                    EmployeeDAO.updateEmployee(uid, uname, udept, usalary);
                    break;

                case 5: // DELETE
                    System.out.print("Enter Employee ID to Delete: ");
                    int did = sc.nextInt();

                    EmployeeDAO.deleteEmployee(did);
                    break;

                case 6: // EXIT
                    System.out.println("Exiting application...");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice! Try again.");
            }

        } while (choice != 6);

        sc.close();
    }
}
