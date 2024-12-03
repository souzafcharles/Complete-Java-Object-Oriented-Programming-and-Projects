package com.souza.charles.entities;
/**
 Course title: Complete Java - Object-Oriented Programming + Projects
 Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
 Exercise done by: Charles Fernandes de Souza
 Date: November 16, 2024
 */
public class Student {
    private String name;
    private double gradeFirstSemester;
    private double gradeSecondSemester;

    public Student() {
    }

    public Student(String name, double gradeFirstSemester, double gradeSecondSemester) {
        this.name = name;
        this.gradeFirstSemester = gradeFirstSemester;
        this.gradeSecondSemester = gradeSecondSemester;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGradeFirstSemester() {
        return gradeFirstSemester;
    }

    public void setGradeFirstSemester(double gradeFirstSemester) {
        this.gradeFirstSemester = gradeFirstSemester;
    }

    public double getGradeSecondSemester() {
        return gradeSecondSemester;
    }

    public void setGradeSecondSemester(double gradeSecondSemester) {
        this.gradeSecondSemester = gradeSecondSemester;
    }

    public double calculateAverageGrade(){
        return (this.gradeFirstSemester + this.gradeSecondSemester) / 2.0;
    }

    public static String showNameStudentApproved(Student[] students){
        StringBuilder nameStudentsApproved = new StringBuilder();
        for (int i = 0; i < students.length; i++) {
            if (students[i].calculateAverageGrade() >= 6.0) {
                nameStudentsApproved.append("\n");
                nameStudentsApproved.append(students[i].getName());
            }
        }
        return nameStudentsApproved.toString();
    }
}