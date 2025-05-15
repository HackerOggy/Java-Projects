import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    int rollNumber;
    int[] marks = new int[3];
    int total;
    double average;
    String grade;

    // Method to calculate total, average, and grade
    void calculateResults() {
        total = 0;
        for (int mark : marks) {
            total += mark;
        }
        average = total / 3.0;

        if (average >= 75) {
            grade = "A";
        } else if (average >= 60) {
            grade = "B";
        } else if (average >= 40) {
            grade = "C";
        } else {
            grade = "Fail";
        }
    }
}

public class StudentGradeManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> studentList = new ArrayList<>();

        while (true) {
            System.out.println("\n=== Student Grade Management System ===");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            if (choice == 1) {
                Student student = new Student();
                scanner.nextLine(); // consume leftover newline
                System.out.print("Enter student name: ");
                student.name = scanner.nextLine();
                System.out.print("Enter roll number: ");
                student.rollNumber = scanner.nextInt();

                for (int i = 0; i < 3; i++) {
                    System.out.print("Enter marks for Subject " + (i + 1) + ": ");
                    student.marks[i] = scanner.nextInt();
                }

                student.calculateResults(); // calculate total, average, grade
                studentList.add(student); // add student to the list
                System.out.println("Student added successfully!");

            } else if (choice == 2) {
                System.out.println("\n--- All Student Records ---");
                for (Student s : studentList) {
                    System.out.println("Name: " + s.name);
                    System.out.println("Roll No: " + s.rollNumber);
                    System.out.println("Marks: " + s.marks[0] + ", " + s.marks[1] + ", " + s.marks[2]);
                    System.out.println("Total: " + s.total);
                    System.out.println("Average: " + s.average);
                    System.out.println("Grade: " + s.grade);
                    System.out.println("---------------------------");
                }

                if (studentList.size() == 0) {
                    System.out.println("No students added yet.");
                }

            } else if (choice == 3) {
                System.out.println("Exiting the program. Goodbye!");
                break;
            } else {
                System.out.println("Invalid choice. Try again.");
            }
        }

        scanner.close();
    }
}

/*
Output:

=== Student Grade Management System ===
1. Add Student
2. View All Students
3. Exit
Enter your choice: 1
Enter student name: Yash
Enter roll number: 1
Enter marks for Subject 1: 90
Enter marks for Subject 2: 96
Enter marks for Subject 3: 80
Student added successfully!

=== Student Grade Management System ===
1. Add Student
2. View All Students
3. Exit
Enter your choice: 1
Enter student name: Jay
Enter roll number: 2
Enter marks for Subject 1: 70
Enter marks for Subject 2: 65
Enter marks for Subject 3: 75
Student added successfully!

=== Student Grade Management System ===
1. Add Student
2. View All Students
3. Exit
Enter your choice: 2

--- All Student Records ---
Name: Yash
Roll No: 1
Marks: 90, 96, 80
Total: 266
Average: 88.66666666666667
Grade: A
---------------------------
Name: Jay
Roll No: 2
Marks: 70, 65, 75
Total: 210
Average: 70.0
Grade: B
---------------------------

=== Student Grade Management System ===
1. Add Student
2. View All Students
3. Exit
Enter your choice: 3
Exiting the program. Goodbye!

*/
