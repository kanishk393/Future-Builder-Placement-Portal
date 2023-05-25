import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class FutureBuilder {
    static Scanner scn;
    static List<Company> companyList;
    static List<Student> studentList;
    static PlacementCell placementCell;
    static HashMap<String, List<Student>> companytoSelectedStudent;

    public static void main(String[] args) {
        scn = new Scanner(System.in);
        companyList = new ArrayList<>();
        studentList = new ArrayList<>();
        placementCell = new PlacementCell();
        companytoSelectedStudent = new HashMap<>();
        String applicationStart = "Enter FutureBuilder";
        // scn.nextLine();
        // System.out.println(applicationStart);
        if (applicationStart.equals("Enter FutureBuilder")) {
            int opt = 1;
            do {
                System.out
                        .println("Welcome to FutureBuilder:\n\t1) Enter the Application\n\t2) Exit the Application\n");
                opt = scn.nextInt();
                if (opt == 1)
                    futureBuilder();
            } while (opt == 1);
        }
        scn.close();
    }

    private static void futureBuilder() {

        int opt;
        do {
            System.out.println(
                    "Choose The mode you want to Enter in:-\n\t1) Enter as Student Mode\n\t2) Enter as Company Mode\n\t3) Enter as Placement Cell Mode\n\t4) Return To Main Application\n");
            opt = scn.nextInt();
            switch (opt) {
                case 1:
                    studentMode();
                    break;
                case 2:
                    companyMode();
                    break;
                case 3:
                    placementCellMode();
                    break;
                default:
                    return;
            }
        } while (opt > 0 && opt < 4);
    }

    private static void placementCellMode() {

        int opt;
        do {
            System.out.println(
                    "Welcome to IIITD Placement Cell\n\t1) Open Student Registrations\n\t2) Open Company Registrations\n\t3) Get Number of Student Registrations\n\t4) Get Number of Company Registrations\n\t5) Get Number of Offered/Unoffered/Blocked Students\n\t6) Get Student Details\n\t7) Get Company Details\n\t8) Get Average Package\n\t9) Get Company Process Results\n\t10) Back");
            opt = scn.nextInt();
            switch (opt) {
                case 1:
                    placementCell.openStudentRegistration();
                    break;
                case 2:
                    placementCell.openCompanyRegistration();
                    break;
                case 3:
                    placementCell.getStudentRegistrations(studentList);
                    break;
                case 4:
                    placementCell.getCompanyRegistration(companyList);
                    break;
                case 5:
                    placementCell.getStudentsStatus(studentList);
                    break;
                case 6:
                    placementCell.getStudentDetails(studentList);
                    break;
                case 7:
                    placementCell.getCompanyDetails(companyList);
                    break;
                case 8:
                    placementCell.getAvgPackage(companyList);
                    break;
                case 9:
                    placementCell.getCompanyProcess(companytoSelectedStudent);
                    break;
            }
        } while (opt > 0 && opt < 10);
    }

    private static void companyMode() {

        int opt;
        do {
            System.out.println(
                    "Choose the Company Query to perform-\n\t1) Add Company and Details\n\t2) Choose Company\n\t3) Get Available Companies\n\t4) Back");
            Company company = new Company();
            opt = scn.nextInt();
            switch (opt) {
                case 1:

                    companyList.add(company.setCompanyDetails());
                    break;
                case 2:
                    company.chooseCompany(companyList, placementCell);
                    break;
                case 3:
                    company.getAvailableCompanies(companyList);
                    break;
            }
        } while (opt > 0 && opt < 4);
    }

    private static void studentMode() {
        int opt;
        do {
            System.out.println(
                    "Choose the Student Query to perform\n\t1) Enter as a Student(Give Student Name, and Roll No.)\n\t2) Add students\n\t3) Back");
            opt = scn.nextInt();
            switch (opt) {
                case 1:
                    enterStudent();
                    break;
                case 2:
                    addStudents();
                    break;
            }
        } while (opt > 0 && opt < 3);
    }

    private static void enterStudent() {
        scn.nextLine();
        String[] studentDetail = scn.nextLine().split(" ");
        int rollNo = Integer.valueOf(studentDetail[studentDetail.length - 1]);
        for (Student student : studentList)
            if (student.getRollNo() == rollNo) {
                student.chooseStudent(companyList, placementCell, companytoSelectedStudent);
                break;
            }
    }

    private static void addStudents() {
        System.out.println("Number of students to add");
        int numStudents = scn.nextInt();
        System.out.println("Please add students Name, Roll No, CGPA, Branch(in order):");
        for (; numStudents > 0; numStudents--) {
            Student student = new Student();
            student.setStudentDetails();
            studentList.add(student);
        }
    }

}