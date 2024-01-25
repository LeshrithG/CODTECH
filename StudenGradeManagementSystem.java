import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String name;
    private int rollNumber;
    private double[] subjectMarks;

    public Student(String name, int rollNumber, double[] subjectMarks) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.subjectMarks = subjectMarks;
    }

    public String getName() {
        return name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public double[] getSubjectMarks() {
        return subjectMarks;
    }
}

class GradeCalculator {
    public static double calculatePercentage(double[] subjectMarks) {
        double totalMarks = 0;
        for (double mark : subjectMarks) {
            totalMarks += mark;
        }
        return totalMarks / subjectMarks.length;
    }

    public static char calculateGrade(double percentage) {
        if (percentage >= 90) {
            return 'A';
        } else if (percentage >= 80) {
            return 'B';
        } else if (percentage >= 70) {
            return 'C';
        } else if (percentage >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }
}

class StudentGradeManagementSystem {
    private static ArrayList<Student> studentList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\nStudent Grade Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Update Student");
            System.out.println("3. Delete Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    updateStudent();
                    break;
                case 3:
                    deleteStudent();
                    break;
                case 4:
                    displayAllStudents();
                    break;
                case 5:
                    System.out.println("Exiting program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }

        } while (choice != 5);

        scanner.close();
    }

    private static void addStudent() {
        System.out.print("Enter student name: ");
        String name = scanner.next();

        System.out.print("Enter roll number: ");
        int rollNumber = scanner.nextInt();

        System.out.print("Enter number of subjects: ");
        int numSubjects = scanner.nextInt();

        double[] subjectMarks = new double[numSubjects];
        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Enter marks for Subject " + (i + 1) + ": ");
            subjectMarks[i] = scanner.nextDouble();
        }

        Student student = new Student(name, rollNumber, subjectMarks);
        studentList.add(student);

        System.out.println("Student added successfully!");
    }

    private static void updateStudent() {
        System.out.print("Enter the roll number of the student to update: ");
        int rollNumber = scanner.nextInt();

        int index = findStudentIndex(rollNumber);

        if (index != -1) {
            System.out.print("Enter the number of subjects to update: ");
            int numSubjects = scanner.nextInt();

            double[] subjectMarks = new double[numSubjects];
            for (int i = 0; i < numSubjects; i++) {
                System.out.print("Enter updated marks for Subject " + (i + 1) + ": ");
                subjectMarks[i] = scanner.nextDouble();
            }

            studentList.get(index).getSubjectMarks();
            System.out.println("Student information updated successfully!");
        } else {
            System.out.println("Student not found with the given roll number.");
        }
    }

    private static void deleteStudent() {
        System.out.print("Enter the roll number of the student to delete: ");
        int rollNumber = scanner.nextInt();

        int index = findStudentIndex(rollNumber);

        if (index != -1) {
            studentList.remove(index);
            System.out.println("Student deleted successfully!");
        } else {
            System.out.println("Student not found with the given roll number.");
        }
    }

    private static void displayAllStudents() {
        if (studentList.isEmpty()) {
            System.out.println("No student records available.");
        } else {
            System.out.println("\nStudent Records:");
            for (Student student : studentList) {
                displayStudentDetails(student);
            }
        }
    }

    private static void displayStudentDetails(Student student) {
        System.out.println("\nName: " + student.getName());
        System.out.println("Roll Number: " + student.getRollNumber());
        System.out.println("Subject Marks: ");
        for (int i = 0; i < student.getSubjectMarks().length; i++) {
            System.out.println("Subject " + (i + 1) + ": " + student.getSubjectMarks()[i]);
        }

        double percentage = GradeCalculator.calculatePercentage(student.getSubjectMarks());
        char grade = GradeCalculator.calculateGrade(percentage);

        System.out.println("Percentage: " + percentage);
        System.out.println("Grade: " + grade);
    }

    private static int findStudentIndex(int rollNumber) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getRollNumber() == rollNumber) {
                return i;
            }
        }
        return -1;
    }
}
