package com.skillnext;

public class Student {
    private int id;
    private String name;
    private int semester;
    private String dept;

    // Constructors
    // Used when retrieving data (has an ID)
    public Student(int id, String name, int semester, String dept) {
        this.id = id;
        this.name = name;
        this.semester = semester;
        this.dept = dept;
    }

    // Used when inserting new data (ID is auto-generated)
    public Student(String name, int semester, String dept) {
        this.name = name;
        this.semester = semester;
        this.dept = dept;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    // toString method for easy printing
    @Override
    public String toString() {
        return "Student [ID=" + id + ", Name=" + name + ", Semester=" + semester + ", Department=" + dept + "]";
    }
}