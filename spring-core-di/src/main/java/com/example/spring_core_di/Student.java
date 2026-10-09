package com.example.spring_core_di;



public class Student {

    private final Course course;

    public Student(Course course) {
        this.course = course;
    }

    public void displayDetails() {
        System.out.println("Student: Chandan");
        System.out.println("Course: " + course.getCourseName());
    }
}
