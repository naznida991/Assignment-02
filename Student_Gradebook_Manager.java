package pack5;

import java.util.Scanner;

public class Student_Gradebook_Manager {
    private int[] roll = new int[50];
    private String[] name = new String[50];
    private int[] marks = new int[50];
    private int count = 0;

    public void menu() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n==== Student Gradebook Manager ====");
            System.out.println("1) Add Student");
            System.out.println("2) Display All");
            System.out.println("3) Search Student (by Roll / by Name)");
            System.out.println("4) Class Average & Topper");
            System.out.println("5) Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Roll No: ");
                    int r = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String n = sc.nextLine();
                    System.out.print("Enter Marks (0-100): ");
                    int m = sc.nextInt();

                    if (m < 0 || m > 100) {
                        System.out.println("Invalid marks! Try again.");
                        continue;
                    }

                    addStudent(r, n, m);
                    break;

                case 2:
                    displayAll();
                    break;

                case 3:
                    System.out.println("Search by: 1) Rollno  2) Name");
                    int ch = sc.nextInt();
                    sc.nextLine(); // clear newline
                    if (ch == 1) {
                        System.out.print("Enter Rollno: ");
                        int rn = sc.nextInt();
                        search(rn);
                    } else {
                        System.out.print("Enter Name: ");
                        String na = sc.nextLine();
                        search(na);
                    }
                    break;

                case 4:
                    if (count == 0) {
                        System.out.println("No students added yet.");
                    } else {
                        double avg = computeAverage(marks, count);
                        System.out.println("Class Average = " + avg);
                        topper();
                    }
                    break;

                case 5:
                    System.out.println("Exiting system...");
                    return;
            }
        }
    }

    public void addStudent(int r, String n, int m) {
        if (count >= 50) {
            System.out.println("Cannot add more students (limit reached).");
            return;
        }
        roll[count] = r;
        name[count] = n;
        marks[count] = m;
        count++;
        System.out.println("Student added successfully.");
    }

    public void displayAll() {
        if (count == 0) {
            System.out.println("No students to display.");
            return;
        }
        System.out.println("Roll\tName\tMarks\tGrade");
        for (int i = 0; i < count; i++) {
            System.out.println(roll[i] + "\t" + name[i] + "\t" + marks[i] + "\t" + grade(marks[i]));
        }
    }

    public void search(int rn) {
        boolean found = false;
        for (int i = 0; i < count; i++) {
            if (roll[i] == rn) {
                System.out.println("Found student:");
                System.out.println("Roll: " + roll[i]);
                System.out.println("Name: " + name[i]);
                System.out.println("Marks: " + marks[i]);
                System.out.println("Grade: " + grade(marks[i]));
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Student with roll " + rn + " not found.");
        }
    }

    public void search(String na) {
        boolean found = false;
        for (int i = 0; i < count; i++) {
            if (name[i].equalsIgnoreCase(na)) {
                System.out.println("Found student:");
                System.out.println("Roll: " + roll[i]);
                System.out.println("Name: " + name[i]);
                System.out.println("Marks: " + marks[i]);
                System.out.println("Grade: " + grade(marks[i]));
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Student with name " + na + " not found.");
        }
    }

    public double computeAverage(int[] marks, int c) {
        int sum = 0;
        for (int i = 0; i < c; i++) {
            sum += marks[i];
        }
        return (double) sum / c;
    }

    public String grade(int marks) {
        if (marks >= 85) {
            return "A";
        } else if (marks >= 70) {
            return "B";
        } else if (marks >= 50) {
            return "C";
        } else {
            return "F";
        }
    }

    public void topper() {
        int maxIndex = 0;
        for (int i = 1; i < count; i++) {
            if (marks[i] > marks[maxIndex]) {
                maxIndex = i;
            }
        }
        System.out.println("Topper: " + name[maxIndex] + " (Roll " + roll[maxIndex] + ") with " + marks[maxIndex] + " marks, Grade " + grade(marks[maxIndex]));
    }

    public static void main(String[] args) {
        Student_Gradebook_Manager student1 = new Student_Gradebook_Manager();
        student1.menu();
    }
}

