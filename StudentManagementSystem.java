
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Collections;
import java.util.Scanner;
public class StudentManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> ids = new ArrayList<>();
        ArrayList<String> names = new ArrayList<>();
        ArrayList<Integer> marks = new ArrayList<>();
        LinkedList<String> attendance = new LinkedList<>();
        int choice;
        do {
            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student Marks");
            System.out.println("5. Remove Student");
            System.out.println("6. Add Student Attendance");
            System.out.println("7. Display Attendance");
            System.out.println("8. Remove Attendance");
            System.out.println("9. Display Student Statistics");
            System.out.println("10. Sort Student Names");
            System.out.println("11. Exit");
            System.out.print("Enter Your Choice: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter Student ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    if (ids.contains(id)) {
                        System.out.println("Student ID Already Exists!");
                        break;
                    }
                    System.out.print("Enter Student Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Student Marks: ");
                    int mark = sc.nextInt();
                    sc.nextLine();
                    if (mark < 0 || mark > 100) {
                        System.out.println("Invalid Marks!");
                    } else {
                        ids.add(id);
                        names.add(name);
                        marks.add(mark);
                        System.out.println("Student Added Successfully!");
                    }
                    break;
                case 2:
                    if (names.isEmpty()) {
                        System.out.println("No Students Available!");
                    } else {
                        System.out.println("\nStudent ID    Name    Marks");
                        for (int i = 0; i < names.size(); i++) {
                            System.out.println(ids.get(i) + "    "
                                    + names.get(i) + "    " + marks.get(i));
                        }
                        System.out.println("Total Students: " + names.size());
                    }
                    break;
                case 3:
                    System.out.print("Enter Student Name: ");
                    name = sc.nextLine();
                    int index = names.indexOf(name);
                    if (index != -1) {
                        System.out.println("Student Found!");
                        System.out.println("ID: " + ids.get(index));
                        System.out.println("Name: " + names.get(index));
                        System.out.println("Marks: " + marks.get(index));
                    } else {
                        System.out.println("Student Not Found!");
                    }
                    break;
                case 4:
                    System.out.print("Enter Student Name: ");
                    name = sc.nextLine();
                    index = names.indexOf(name);
                    if (index != -1) {
                        System.out.print("Enter New Marks: ");
                        mark = sc.nextInt();
                        sc.nextLine();
                        if (mark >= 0 && mark <= 100) {
                            marks.set(index, mark);
                            System.out.println("Marks Updated Successfully!");
                        } else {
                            System.out.println("Invalid Marks!");
                        }
                    } else {
                        System.out.println("Student Not Found!");
                    }
                    break;
                case 5:
                    System.out.print("Enter Student Name: ");
                    name = sc.nextLine();
                    index = names.indexOf(name);
                    if (index != -1) {
                        ids.remove(index);
                        names.remove(index);
                        marks.remove(index);
                        attendance.remove(name);
                        System.out.println("Student Removed Successfully!");
                    } else {
                        System.out.println("Student Not Found!");
                    }
                    break;
                case 6:
                    System.out.print("Enter Student Name: ");
                    name = sc.nextLine();
                    if (names.contains(name)) {
                        if (!attendance.contains(name)) {
                            System.out.println("1. Add at Beginning");
                            System.out.println("2. Add at End");
                            System.out.print("Enter Choice: ");
                            int option = sc.nextInt();
                            sc.nextLine();
                            if (option == 1) {
                                attendance.addFirst(name);
                                System.out.println("Attendance Added!");
                            } else if (option == 2) {
                                attendance.addLast(name);
                                System.out.println("Attendance Added!");
                            } else {
                                System.out.println("Invalid Choice!");
                            }
                        } else {
                            System.out.println("Attendance Already Added!");
                        }
                    } else {
                        System.out.println("Student Not Found!");
                    }
                    break;

                case 7:
                    if (attendance.isEmpty()) {
                        System.out.println("No Attendance Available!");
                    } else {
                        System.out.println("Present Students: " + attendance);
                        System.out.println("Total Present: " + attendance.size());
                    }
                    break;

                case 8:
                    System.out.print("Enter Student Name: ");
                    name = sc.nextLine();

                    if (attendance.contains(name)) {
                        attendance.remove(name);
                        System.out.println("Attendance Removed!");
                    } else {
                        System.out.println("Student Not Found in Attendance!");
                    }
                    break;

                case 9:
                    if (marks.isEmpty()) {
                        System.out.println("No Student Records Available!");
                    } else {
                        int highest = Collections.max(marks);
                        int lowest = Collections.min(marks);
                        int total = 0;
                        int count = 0;

                        for (int m : marks) {
                            total = total + m;

                            if (m > 75) {
                                count++;
                            }
                        }

                        double average = (double) total / marks.size();

                        System.out.println("Total Students: " + names.size());
                        System.out.println("Highest Marks: " + highest);
                        System.out.println("Lowest Marks: " + lowest);
                        System.out.printf("Average Marks: %.2f%n", average);
                        System.out.println("Students Above 75: " + count);
                    }
                    break;

                case 10:
                    if (names.isEmpty()) {
                        System.out.println("No Students Available!");
                    } else {
                        ArrayList<String> sortedNames = new ArrayList<>(names);

                        Collections.sort(sortedNames);
                        System.out.println("Ascending Order: " + sortedNames);

                        Collections.reverse(sortedNames);
                        System.out.println("Descending Order: " + sortedNames);
                    }
                    break;

                case 11:
                    System.out.println("Thank You!");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 11);

        sc.close();
    }
}