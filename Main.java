import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Course: F2025 MAD204-01 Java Development for MA
 * Lab: 1
 * Student: Ishmeet Singh (ID: A00202436)
 * Date: 2025-09-19
 *
 * Description:
 * This program is a Gradebook & Utilities app.
 * Features:
 * - Add students and enter grades
 * - Show all students with averages and letter grades
 * - Utility demos: operator precedence, type casting, recursion
 * - Input validation and loop coverage (for, while, do-while, for-each)
 */

public class Main {
    private static ArrayList<Student> students = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- Gradebook & Utilities Menu ---");
            System.out.println("1. Add Student");
            System.out.println("2. Enter Grades");
            System.out.println("3. Show All Students");
            System.out.println("4. Utilities");
            System.out.println("5. Exit");

            int choice = getIntInput("Enter choice: ");

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> enterGrades();
                case 3 -> showAllStudents();
                case 4 -> utilitiesMenu();
                case 5 -> {
                    System.out.println("Exiting program. Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid choice, try again!");
            }
        }
    }

    /** Add a student with ID and Name */
    private static void addStudent() {
        int id = getIntInput("Enter Student ID: ");
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();
        students.add(new Student(id, name));
        System.out.println("Student added successfully!");

        // do-while loop demo
        String again;
        do {
            System.out.print("Add another student? (y/n): ");
            again = scanner.nextLine().toLowerCase();
            if (again.equals("y")) addStudent();
        } while (!again.equals("n"));
    }

    /** Enter grades for a specific student */
    private static void enterGrades() {
        int id = getIntInput("Enter Student ID to enter grades: ");
        Student found = findStudentById(id);
        if (found == null) {
            System.out.println("Student not found!");
            return;
        }
        System.out.println("Entering grades for " + found.getName());
        for (int i = 0; i < 5; i++) { // for loop demo
            double grade = getDoubleInput("Enter grade " + (i + 1) + ": ");
            found.setGrade(i, grade);
        }
    }

    /** Show all students */
    private static void showAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students added yet.");
            return;
        }
        System.out.println("\n--- Student List ---");
        // for-each loop demo
        for (Student s : students) {
            System.out.println(s);
        }
    }

    /** Utilities submenu */
    private static void utilitiesMenu() {
        System.out.println("\n--- Utilities Menu ---");
        System.out.println("1. Operator Precedence Demo");
        System.out.println("2. Type Casting Demo");
        System.out.println("3. Recursion Countdown");
        int choice = getIntInput("Enter choice: ");

        switch (choice) {
            case 1 -> operatorDemo();
            case 2 -> castingDemo();
            case 3 -> {
                int n = getIntInput("Enter number for countdown: ");
                countdown(n);
            }
            default -> System.out.println("Invalid choice!");
        }
    }

    /** Operator precedence demo */
    private static void operatorDemo() {
        System.out.println("2 + 3 * 4 = " + (2 + 3 * 4));
        System.out.println("(2 + 3) * 4 = " + ((2 + 3) * 4));
        System.out.println("Explanation: Multiplication has higher precedence than addition.");
    }

    /** Type casting demo */
    private static void castingDemo() {
        int a = 5;
        double b = a; // widening
        double c = 9.8;
        int d = (int) c; // narrowing (truncation)
        System.out.println("Widening: int 5 -> double " + b);
        System.out.println("Narrowing: double 9.8 -> int " + d);
    }

    /** Recursion demo */
    private static void countdown(int n) {
        if (n < 0) {
            System.out.println("Negative number not allowed.");
            return;
        }
        if (n == 0) {
            System.out.println("Done!");
        } else {
            System.out.println(n);
            countdown(n - 1); // recursive call
        }
    }

    /** Find student by ID */
    private static Student findStudentById(int id) {
        for (Student s : students) {
            if (s.getId() == id) return s;
        }
        return null;
    }

    /** Safe integer input */
    private static int getIntInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                int val = Integer.parseInt(scanner.nextLine());
                return val;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input, enter an integer.");
            }
        }
    }

    /** Safe double input */
    private static double getDoubleInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                double val = Double.parseDouble(scanner.nextLine());
                return val;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input, enter a number.");
            }
        }
    }
}
