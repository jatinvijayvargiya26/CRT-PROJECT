import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String name;
    private String studentId;
    private String hobby;
    private String sports;
    private double attendancePercentage;

    public Student(String name, String studentId, String hobby, String sports, double attendancePercentage) {
        this.name = name;
        this.studentId = studentId;
        this.hobby = hobby;
        this.sports = sports;
        this.attendancePercentage = attendancePercentage;
    }

    @Override
    public String toString() {
        return "Student Name: " + name + ", Student ID: " + studentId + 
               ", Hobby: " + hobby + ", Sports: " + sports + 
               ", Attendance Percentage: " + attendancePercentage + "%";
    }

    public String getStudentId() {
        return studentId;
    }

    // New method to update student details
    public void updateDetails(String name, String hobby, String sports, double attendancePercentage) {
        this.name = name;
        this.hobby = hobby;
        this.sports = sports;
        this.attendancePercentage = attendancePercentage;
    }
}

class ClassroomManagementSystem {
    private ArrayList<Student> students;

    public ClassroomManagementSystem() {
        students = new ArrayList<>();
    }

    public void addStudent(String name, String studentId, String hobby, String sports, double attendancePercentage) {
        Student newStudent = new Student(name, studentId, hobby, sports, attendancePercentage);
        students.add(newStudent);
        System.out.println("Student added: " + newStudent);
    }

    public void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No students to display.");
            return;
        }
        System.out.println("List of Students:");
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public void deleteStudent(String studentId) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getStudentId().equals(studentId)) {
                students.remove(i);
                System.out.println("Student with ID " + studentId + " has been deleted.");
                return;
            }
        }
        System.out.println("Student with ID " + studentId + " not found.");
    }

    // New method to update student details
    public void updateStudent(String studentId) {
        for (Student student : students) {
            if (student.getStudentId().equals(studentId)) {
                Scanner scanner = new Scanner(System.in);
                System.out.print("Enter new student name: ");
                String name = scanner.nextLine();
                System.out.print("Enter new hobby: ");
                String hobby = scanner.nextLine();
                System.out.print("Enter new sports: ");
                String sports = scanner.nextLine();
                System.out.print("Enter new attendance percentage: ");
                double attendancePercentage = scanner.nextDouble();
                student.updateDetails(name, hobby, sports, attendancePercentage);
                System.out.println("Student details updated: " + student);
                return;
            }
        }
        System.out.println("Student with ID " + studentId + " not found.");
    }
}

public class Main {
    public static void main(String[] args) {
        ClassroomManagementSystem cms = new ClassroomManagementSystem();
        Scanner scanner = new Scanner(System.in);
        String choice;

        do {
            System.out.println("\n1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Delete Student");
            System.out.println("4. Update Student Details"); // New option
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter student ID: ");
                    String studentId = scanner.nextLine();
                    System.out.print("Enter student hobby: ");
                    String hobby = scanner.nextLine();
                    System.out.print("Enter sports played by student: ");
                    String sports = scanner.nextLine();
                    System.out.print("Enter attendance percentage: ");
                    double attendancePercentage = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                    cms.addStudent(name, studentId, hobby, sports, attendancePercentage);
                    break;
                case "2":
                    cms.displayStudents();
                    break;
                case "3":
                    System.out.print("Enter student ID to delete: ");
                    String idToDelete = scanner.nextLine();
                    cms.deleteStudent(idToDelete);
                    break;
                case "4":
                System.out.print("Enter student ID to update: ");
                String idToUpdate = scanner.nextLine();
                cms.updateStudent(idToUpdate); // Call the update method
                break;
            case "5":
                System.out.println("Exiting the program.");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    } while (!choice.equals("5"));

    scanner.close();
}
}