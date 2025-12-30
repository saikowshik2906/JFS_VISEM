package com.skillnext1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/addStudent")
public class StudentServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        int sem = Integer.parseInt(request.getParameter("sem"));
        String dept = request.getParameter("dept");

        Student student = new Student(name, sem, dept);
        StudentDAO dao = new StudentDAO();
        dao.addStudent(student);

        response.getWriter().println("Student added successfully!");
    }
}
