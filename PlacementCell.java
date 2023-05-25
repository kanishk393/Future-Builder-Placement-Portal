
// import java.lang.management.PlatformManagedObject;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class PlacementCell {
    Date companyOpenDate;
    Date studentOpenDate;
    Date companyCloseDate;
    Date studentCloseDate;

    private Scanner scn;

    public PlacementCell() {
        scn = new Scanner(System.in);
    }

    public void openStudentRegistration() {
        System.out.println(
                "Fill in the details:-\n\t1) Set the Opening time for Student registrations\n\t2) Set the Closing time for Student registrations");

        studentOpenDate = getDateFromString(scn.nextLine());
        studentCloseDate = getDateFromString(scn.nextLine());

    }

    public void openCompanyRegistration() {
        System.out.println(
                "Fill in the details:-\n\t1) Set the Opening time for company registrations\n\t2) Set the Closing time for company registrations");
        companyOpenDate = getDateFromString(scn.nextLine());
        companyCloseDate = getDateFromString(scn.nextLine());

    }

    private Date getDateFromString(String str) {
        // String[] d = str.split("[,:thsndr])");
        Date date = new Date();

        // write logic for converting string to date and time

        return date;
    }

    public void getStudentRegistrations(List<Student> studentList) {
    }

    public void getCompanyRegistration(List<Company> companyList) {

    }

    public void getStudentsStatus(List<Student> studentList) {
        int k = 1;
        for (Student student : studentList)
            System.out.println(k++ + student.getStudentName() + " :" + student.getStudentStatus());
    }

    public void getStudentDetails(List<Student> studentList) {
        int k = 1;
        for (Student student : studentList) {
            System.out.print(k++ + ") ");
            student.displayInfo();
            System.out.println();
        }
    }

    public void getCompanyDetails(List<Company> companyList) {
        int i = 1;
        for (Company company : companyList)
            System.out
                    .println("\n\t" + i++ + " Company Name: " + company.getcompanyName() + "\n\tCompany role offering: "
                            + company.getCompanyRole() + "\n\tCompany Package" + company.getCompanyCtc()
                            + "\n\tCompany CGPA criteria "
                            + company.getCompanyMinCGPA());
    }

    public void getAvgPackage(List<Company> companyList) {
        double avg = 0;
        for (Company company : companyList)
            avg += company.getCompanyCtc();
        System.out.println("The average package is " + avg / companyList.size());
    }

    public void getCompanyProcess(HashMap<String, List<Student>> companytoSelectedStudent) {
        System.out.println("\nEnter Company Name: ");
        String company = scn.nextLine();
        List<Student> selectedStudents = companytoSelectedStudent.get(company);
        int k = 1;
        for (Student student : selectedStudents) {
            System.out.print(k++ + ")");
            student.displayInfo();

        }
    }
}
