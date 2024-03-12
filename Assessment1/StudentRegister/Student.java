// ITELEC1: Object-oriented Programming (Assessment 1: Student Registration)
// ----------------------------------------------------------------
/* This Java program allows users to register students, view registered students, and delete students by their index. 
   It uses the Student and Course classes to represent student and course information, respectively. */
// ----------------------------------------------------------------
// Author: CAPISTRANO, John Jabez
// BS_INFORMATION TECHNOLOGY 2D
// September 10, 2023

public class Student {
    private String fullName;
    private String yearAndSection;
    private String courseID;
    private String studentID;

    public Student(String fullName, String yearAndSection, String courseID, String studentID) {
        this.fullName = fullName;
        this.yearAndSection = yearAndSection;
        this.courseID = courseID;
        this.studentID = studentID;
    }

    public String getFullName() {
        return fullName;
    }

    public String getYearAndSection() {
        return yearAndSection;
    }

    public String getCourseID() {
        return courseID;
    }

    public String getStudentID() {
        return studentID;
    }

    @Override
    public String toString() {
        return "Full Name: " + fullName + "\nYear and Section: " + yearAndSection + "\nCourse ID: " + courseID
                + "\nStudent ID: " + studentID + "\n";
    }
}
