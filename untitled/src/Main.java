import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);
    public static ArrayList<Student> studentList = new ArrayList<>();

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\nStudent Management System");
            System.out.println("1. Enter Student List");
            System.out.println("2. Find Students by Last Name");
            System.out.println("3. Find and Edit Student by Full Name");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine(); // Consume remaining newline character

            switch (choice) {
                case 1:
                    enterStudentList();
                    break;
                case 2:
                    findStudentsByLastName();
                    break;
                case 3:
                    findAndEditStudent();
                    break;
                case 4:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 4);
    }

    public static void enterStudentList() {
        System.out.println("Enter the number of students: ");
        int numStudents = scanner.nextInt();
        scanner.nextLine(); // Consume remaining newline character

        for (int i = 0; i < numStudents; i++) {
            Student student = new Student();
            System.out.print("Enter student first name: ");
            student.setFirstName(scanner.nextLine());
            System.out.print("Enter student last name: ");
            student.setLastName(scanner.nextLine());
            studentList.add(student);
        }
        System.out.println("Students entered successfully!");
    }

    public static void findStudentsByLastName() {
        System.out.print("Enter student last name to find: ");
        String lastName = scanner.nextLine();

        boolean found = false;
        for (Student student : studentList) {
            if (student.getLastName().equalsIgnoreCase(lastName)) {
                System.out.println(student);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No student found with last name: " + lastName);
        }
    }

    public static void findAndEditStudent() {
        System.out.print("Enter student full name to find (first last): ");
        String fullName = scanner.nextLine();

        String[] names = fullName.split(" ");

        if (names.length != 2) {
            System.out.println("Invalid full name format! Please enter 'first last'.");
            return;
        }

        String firstName = names[0];
        String lastName = names[1];

        Student foundStudent = null;
        for (Student student : studentList) {
            if (student.getFirstName().equalsIgnoreCase(firstName) &&
                    student.getLastName().equalsIgnoreCase(lastName)) {
                foundStudent = student;
                break;
            }
        }

        if (foundStudent == null) {
            System.out.println("No student found with that full name!");
            return;
        }

        System.out.println("Found student:");
        System.out.println(foundStudent);

        System.out.print("Enter new first name (or leave blank to keep old): ");
        String newFirstName = scanner.nextLine();
        if (!newFirstName.isEmpty()) {
            foundStudent.setFirstName(newFirstName);
        }

        System.out.print("Enter new last name (or leave blank to keep old): ");
        String newLastName = scanner.nextLine();
        if (!newLastName.isEmpty()) {
            foundStudent.setLastName(newLastName);
        }

        System.out.println("Student details updated!");
    }
}

class Student {
    private String firstName;
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
