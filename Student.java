/**
 * Course: F2025 MAD204-01 Java Development for MA
 * Lab: 1
 * Student: Ishmeet Singh (ID: A00202436)
 * Date: 2025-09-19
 *
 * Description:
 * This class models a Student with ID, name, and grades.
 * Provides methods to set grades, compute average, and return letter grade.
 */

public class Student {
    private String name;
    private int id;
    private double[] grades; // Array of 5 grades

    /**
     * Constructor to initialize a student with id, name, and 5 grades.
     * @param id Student ID
     * @param name Student Name
     */
    public Student(int id, String name) {
        this.id = id;
        this.name = name;
        this.grades = new double[5]; // default 0.0
    }

    /**
     * Set a grade at a given index (0–4).
     * @param index Index of grade (0–4)
     * @param value Grade value (0–100)
     */
    public void setGrade(int index, double value) {
        if (index >= 0 && index < grades.length) {
            grades[index] = value;
        } else {
            System.out.println("Invalid grade index!");
        }
    }

    /**
     * Compute the average of all grades.
     * @return Average grade as double
     */
    public double average() {
        double sum = 0;
        for (double g : grades) {
            sum += g;
        }
        return sum / grades.length;
    }

    /**
     * Compute letter grade based on average.
     * @return char A, B, C, D, F
     */
    public char letterGrade() {
        double avg = average();
        if (avg >= 90) return 'A';
        else if (avg >= 80) return 'B';
        else if (avg >= 70) return 'C';
        else if (avg >= 60) return 'D';
        else return 'F';
    }

    /**
     * String representation of student.
     * @return Student info string
     */
    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name +
                ", Avg: " + String.format("%.2f", average()) +
                " (" + letterGrade() + ")";
    }

    // Getters for name and id
    public String getName() { return name; }
    public int getId() { return id; }
}
