import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Company {
    private String companyName;
    private String role;
    private float ctc;
    private float minCGPA;
    private Date regDate;

    private Scanner scn;

    public Company() {
        scn = new Scanner(System.in);
    }

    private void registerToInstitute(PlacementCell placementCell) {
        this.regDate = getDateFromString(scn.nextLine());
        if (this.regDate.compareTo(placementCell.companyCloseDate) == 0
                || this.regDate.compareTo(placementCell.companyOpenDate) == 0
                || (this.regDate.after(placementCell.companyOpenDate)
                        && this.regDate.before(placementCell.companyCloseDate)))
            System.out.println("Registered!!!");
        else
            System.out.println("Registered!");

    }

    private Date getDateFromString(String str) {
        // String[] d = str.split("[,:thsndr])");
        Date date = new Date();

        // write logic for converting string to date and time

        return date;
    }

    public List<String> getSelectedStudents() {
        List<String> selectedStudents = new ArrayList<>();
        return selectedStudents;

    }

    private void updateRole(String role) {
        this.role = role;
    }

    private void updateCGPA(float minCGPA) {
        this.minCGPA = minCGPA;
    }

    private void updateCtc(float ctc) {
        this.ctc = ctc;
    }

    public Company setCompanyDetails() {

        Company newCompany = new Company();
        System.out.print("\nName: ");
        newCompany.companyName = scn.nextLine();
        System.out.print("\nRole: ");
        newCompany.role = scn.nextLine();
        System.out.print("\nCtc: ");
        newCompany.ctc = scn.nextFloat();
        System.out.print("\nMinCGPA: ");
        newCompany.minCGPA = scn.nextFloat();
        return newCompany;

    }

    public void chooseCompany(List<Company> companies, PlacementCell placementCell) {
        System.out.println("Choose To enter into mode of Available Companies:-");
        int k = 1;
        for (Company company : companies)
            System.out.println("\t " + k++ + ") " + company.companyName);
        int selectedCompanyidx = scn.nextInt();
        Company company = companies.get(selectedCompanyidx - 1);

        int opt;
        do {
            System.out.println("Welcome " + company.companyName
                    + "\n\t1) Update Role\n\t2) Update Package\n\t3) Update CGPA criteria\n\t4) Register To Institute Drive\n\t5) Back");
            opt = scn.nextInt();
            switch (opt) {
                case 1:
                    scn.nextLine();
                    company.updateRole(scn.nextLine());
                    break;
                case 2:
                    company.updateCtc(scn.nextFloat());
                    break;
                case 3:
                    company.updateCGPA(scn.nextFloat());
                    break;
                case 4:
                    company.registerToInstitute(placementCell);
                    break;
            }
        } while (opt > 0 && opt < 5);

    }

    public void getAvailableCompanies(List<Company> companies) {
        System.out.println("List of All available companies is as follows:");
        int i = 1;
        for (Company company : companies)
            System.out.println("\n\t" + i++ + " Company Name: " + company.companyName + "\n\tCompany role offering: "
                    + company.role + "\n\tCompany Package" + company.ctc + "\n\tCompany CGPA criteria "
                    + company.minCGPA);
    }

    public String getcompanyName() {
        return this.companyName;
    }

    public String getCompanyRole() {
        return this.role;
    }

    public float getCompanyCtc() {
        return this.ctc;
    }

    public float getCompanyMinCGPA() {
        return this.minCGPA;
    }

    public void displayInfo() {

    }

}
