// ITELEC1: Object-oriented Programming (Assessment 1: Student Registration)
// ----------------------------------------------------------------
/* This Java program allows users to register students, view registered students, and delete students by their index. 
   It uses the Student and Course classes to represent student and course information, respectively. */
// ----------------------------------------------------------------
// Author: CAPISTRANO, John Jabez
// BS_INFORMATION TECHNOLOGY 2D
// September 10, 2023

public class Course {
    private String courseID;
    private String courseName;

    public Course(String courseID, String courseName) {
        this.courseID = courseID;
        this.courseName = courseName;
    }

    public String getCourseID() {
        return courseID;
    }

    public String getCourseName() {
        return courseName;
    }
}
