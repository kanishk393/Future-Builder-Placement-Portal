import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Student {
    private String name;
    private int rollNo;
    private float CGPA;
    private String Branch;
    private String status = "unoffered";
    private Date regDate;

    Scanner scn = new Scanner(System.in);
    HashMap<String, PriorityQueue<Company>> nameToRegisteredCompanies = new HashMap<>();
    private float highestCtc;

    private void registerForPlacementDrive() {
        System.out.println(this.name + " Registered for the Placement Drive at IIITD!!!!\nYour details are:");
        this.displayInfo();
    }

    public void getAvailableCompanies(List<Company> companies) {
        System.out.println("List of All available companies is as follows:");
        int i = 1;
        for (Company company : companies)
            System.out.println("\n" + i++ + ") Company Name: " + company.getcompanyName()
                    + "\n\tCompany role offering: " + company.getCompanyRole() + "\n\tCompany Package: "
                    + company.getCompanyCtc() + "\nCompany CGPA criteria: " + company.getCompanyMinCGPA());
    }

    public void updateCGPA(float CGPA) {
        this.CGPA = CGPA;
    }

    public void offerReply(boolean accept) {
        if (accept) {
            PriorityQueue<Company> myCompanies = nameToRegisteredCompanies.get(this.name);
            System.out.println("Congratulations " + this.name + "!!! You have accepted the offer by "
                    + myCompanies.peek().getcompanyName());
            this.status = "offered";
        } else
            this.status = "blocked";
    }

    public void setStudentDetails() {
        System.out.print("\nName: ");
        this.name = scn.nextLine();
        System.out.print("\nRollNo: ");
        this.rollNo = scn.nextInt();
        System.out.print("\nCGPA: ");
        this.CGPA = scn.nextFloat();
        scn.nextLine();
        System.out.print("\nBranch: ");
        this.Branch = scn.nextLine();
        System.out.print("\nRegistration Date: ");
        this.regDate = getDateFromString(scn.nextLine());

    }

    private Date getDateFromString(String str) {
        // String[] d = str.split("[,:thsndr])");
        Date date = new Date();

        // write logic for converting string to date and time

        return date;
    }

    public int getRollNo() {
        return this.rollNo;
    }

    public String getStudentName() {
        return this.name;
    }

    public void chooseStudent(List<Company> companyList, PlacementCell placementCell,
            HashMap<String, List<Student>> companytoSelectedStudent) {
        int opt;
        do {
            System.out.println("Welcome " + this.getStudentName()
                    + "! \n\t1) Register For Placement Drive\n\t2) Register For Company\n\t3) Get All available companies\n\t4) Get Current Status\n\t5) Update CGPA\n\t6) Accept offer\n\t7) Reject offer\n\t8) Back");
            opt = scn.nextInt();
            switch (opt) {

                case 1:
                    this.registerForPlacementDrive();
                    break;
                case 2:
                    this.getAvailableCompanies(companyList);
                    this.registerToCompany(companyList.get(scn.nextInt() - 1), companytoSelectedStudent);
                    break;
                case 3:
                    this.getAvailableCompanies(companyList);
                    break;
                case 4:
                    this.getStatus();
                    break;
                case 5:
                    System.out.print("\nEnter new CGPA:");
                    this.CGPA = scn.nextFloat();
                    break;
                case 6:
                    this.offerReply(true);
                    break;
                case 7:
                    this.offerReply(false);
                    break;
            }

        } while (opt > 0 && opt < 8);
    }

    private void getStatus() {
        if (this.status.equals("blocked"))
            System.out.println("You are blocked from placement drive");
        else {
            PriorityQueue<Company> myCompanies = nameToRegisteredCompanies.get(this.name);
            if (myCompanies.isEmpty()) {
                System.out.println("Sorry! You have no offers yet");
                return;
            }
            System.out.println("Congratulations " + this.name + ". You have been offered by "
                    + myCompanies.peek().getcompanyName() + ".Please accept the offer.");
            this.status = "offered";
            this.highestCtc = myCompanies.peek().getCompanyCtc();
        }
    }

    private void registerToCompany(Company company, HashMap<String, List<Student>> companytoSelectedStudent) {
        nameToRegisteredCompanies.putIfAbsent(this.name, new PriorityQueue<>((a, b) -> {
            return (int) (b.getCompanyCtc() - a.getCompanyCtc());
        }));
        PriorityQueue<Company> companies = nameToRegisteredCompanies.get(this.name);

        if (this.isEligible(company)) {
            companies.add(company);
            System.out.println(
                    "Successfully registered for " + company.getCompanyRole() + " role at " + company.getcompanyName());
            companytoSelectedStudent.putIfAbsent(company.getcompanyName(), new ArrayList<>());
            List<Student> students = companytoSelectedStudent.get(company.getcompanyName());
            students.add(this);
        }
    }

    private boolean isEligible(Company company) {
        if (this.CGPA < company.getCompanyMinCGPA() || this.status.equals("blocked"))
            return false;

        if (this.status.equals("offered") && this.highestCtc > company.getCompanyCtc() * 3)
            return false;

        return true;
    }

    public void displayInfo() {
        System.out.print("Name: " + this.name + "\nRollNo: " + this.rollNo + "\nCGPA: " + this.CGPA + "\nBranch: "
                + this.Branch);
        System.out.println();
    }

    public String getStudentStatus() {
        return this.status;
    }

}