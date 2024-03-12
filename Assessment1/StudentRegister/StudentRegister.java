// ITELEC1: Object-oriented Programming (Assessment 1: Student Registration)
// ----------------------------------------------------------------
/* This Java program allows users to register students, view registered students, and delete students by their index. 
   It uses the Student and Course classes to represent student and course information, respectively. */
// ----------------------------------------------------------------
// Author: CAPISTRANO, John Jabez
// BS_INFORMATION TECHNOLOGY 2D
// September 10, 2023

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentRegister {
    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();
        List<Course> courseList = new ArrayList<>();

        // Adding predefined courses
        courseList.add(new Course("103", "Fundamentals of Database Systems"));
        courseList.add(new Course("001", "Object-Oriented Programming"));
        courseList.add(new Course("108", "Advanced Database Management Systems"));

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n\n-------------------------------------");
            System.out.println("|    Student Interaction Menu:       |");
            System.out.println("|------------------------------------|");
            System.out.println("|                                    |");
            System.out.println("|   Select number and press enter    |");
            System.out.println("|       to perform operation         |");
            System.out.println("|----------------------------------- |");
            System.out.println("|                                    |");
            System.out.println("| 1. Register Student                |");
            System.out.println("| 2. Display all Registered Students |");
            System.out.println("| 3. Delete Student                  |");
            System.out.println("| 4. Exit                            |");
            System.out.println("|                                    |");
            System.out.println("--------------------------------------");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {

                case 1: // Under this option,the program will prompt the user to enter the Student's info, as well as the course ID.
                        // it then has the user input validation to ensure that the course ID is correct from the choices given in the program.
                        // it also ensures that there is no duplicate course ID.

                    System.out.println("");
                    System.out.print("Enter full name: ");
                    String fullName = scanner.nextLine();
                    System.out.print("Enter year and section: ");
                    String yearAndSection = scanner.nextLine();
                    System.out.print("Enter course ID (103, 001, or 108): ");
                    String courseID = scanner.nextLine();
                    System.out.print("Enter student ID: ");
                    String studentID = scanner.nextLine();

                    // Validate course ID
                    boolean validCourseID = false;
                    for (Course course : courseList) {
                        if (course.getCourseID().equals(courseID)) {
                            validCourseID = true;
                            break;
                        }
                    }

                    if (!validCourseID) {
                        System.out.println("Invalid course ID. Please enter a valid course ID.");
                        continue;
                    }

                    // Check if a student with the same course ID already exists
                    boolean duplicateCourseID = false;
                    for (Student student : studentList) {
                        if (student.getCourseID().equals(courseID)) {
                            duplicateCourseID = true;
                            break;
                        }
                    }

                    if (duplicateCourseID) { /*
                                              * This modification ensures that you cannot register more than one student
                                              * in the same course ID.
                                              * If a student with the same course ID already exists,
                                              * the program will display an error message and not allow the
                                              * registration.
                                              */

                        System.out.println("A student with the same course ID already exists.");
                        continue;
                    }

                    Student student = new Student(fullName, yearAndSection, courseID, studentID);
                    studentList.add(student);
                    System.out.println("Student registered successfully.\n");
                    break;

                case 2: // This option will display all the information made in the program.

                    System.out.println("");
                    System.out.println("Registered Students:");
                    System.out.println("");
                    for (Student s : studentList) {
                        System.out.println(s.toString());
                    }
                    break;

                case 3: // If the user wants to delete one student in the registration list, then the program will ask for the Student ID to be removed

                    System.out.println("");
                    System.out.print("Enter student ID to delete: ");
                    String deleteID = scanner.nextLine();
                    boolean deleted = false;

                    for (Student s : studentList) {
                        if (s.getStudentID().equals(deleteID)) {
                            studentList.remove(s);
                            deleted = true;
                            System.out.println("Student with ID " + deleteID + " deleted.\n");
                            break;
                        }
                    }

                    if (!deleted) {
                        System.out.println("Student with ID " + deleteID + " not found.\n");
                    }
                    break;

                case 4: // Put simply to end the program
                
                    System.out.println("");
                    System.out.println("Program ended successfully.");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please enter a valid option.\n");
            }
        }
    }
}
