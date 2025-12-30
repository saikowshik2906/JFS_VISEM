package com.skillnext1;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class App {
    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Student student = new Student();
        student.setName("Mayuri");
        student.setEmail("mayuri@gmail.com");
        student.setMarks(85);

        session.persist(student);

        tx.commit();
        session.close();

        System.out.println("Student inserted successfully!");
    }
}
