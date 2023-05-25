import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Company {
    private String name_comp;
    private String role;
    private float ctc;
    private float minCGPA;
    private Date regDate;

    private Scanner scn;

    public Company() {
        scn = new Scanner(System.in);
    }

    private void ins_reg(p_cell p_cell) {
        this.regDate = date_str(scn.nextLine());
        System.out.println("Registered!!!");
    }

    private Date date_str(String str) {
        Date date = new Date();
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

    public Company comp_details() {

        Company newCompany = new Company();
        System.out.print("\nName: ");
        newCompany.name_comp = scn.nextLine();
        System.out.print("\nRole: ");
        newCompany.role = scn.nextLine();
        System.out.print("\nCtc: ");
        newCompany.ctc = scn.nextFloat();
        System.out.print("\nMinCGPA: ");
        newCompany.minCGPA = scn.nextFloat();
        return newCompany;

    }

    public void comp_choice(List<Company> companies, p_cell p_cell) {
        System.out.println("Choose To enter into mode of Available Companies:-");
        int temp=1;
        for (Company company : companies)

            {   temp=temp+1;
                System.out.println("("+temp+")");
            System.out.println(company.name_comp);}
        int selectedCompanyidx = scn.nextInt();
        Company company=companies.get(selectedCompanyidx-1);
            
                int ele=1;
                while (ele != 0 && ele != 5); 
                {
                    System.out.println("Welcome " + company.name_comp );
                    System.out.println("1) Update Role");
                    System.out.println("2) Update Package");
                    System.out.println("3) Update CGPA criteria");
                    System.out.println("4) Register To Institute Drive");
                    System.out.println("5) Back");
                ele = scn.nextInt();
                    
                    if(ele==1){
                        scn.nextLine();
                        company.updateRole(scn.nextLine());
                        }
                        if(ele==2){
                        company.updateCtc(scn.nextFloat());
                        }
                    else if(ele==3){
                        company.updateCGPA(scn.nextFloat());
                        }
                    else if(ele==4){
                        company.ins_reg(p_cell);
                        }
                
                } 
               

    }

    public void comp_av(List<Company> companies) {
        System.out.println("List of All available companies is as follows:");
        int i = 1;
        for (Company company : companies)
        {
            System.out.println("\n\t" + i++ + " Company Name: " + company.name_comp  );
            System.out.println("Company role offering: "+ company.role );
            System.out.println("Company Package" + company.ctc  );
            System.out.println("Company CGPA criteria " + company.minCGPA);}
    }

    public String comp_name() {
        return this.name_comp;
    }

    public String comp_role() {
        return this.role;
    }

    public float comp_ctc() {
        return this.ctc;
    }

    public float Comp_minCG() {
        return this.minCGPA;
    }


    public void setCompanyName(String name_comp) {
        this.name_comp = name_comp;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public float getCtc() {
        return ctc;
    }

    public void setCtc(float ctc) {
        this.ctc = ctc;
    }

    public float getMinCGPA() {
        return minCGPA;
    }

    public void setMinCGPA(float minCGPA) {
        this.minCGPA = minCGPA;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public Scanner getScn() {
        return scn;
    }

    public void setScn(Scanner scn) {
        this.scn = scn;
    }

}