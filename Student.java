import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
// import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

// import javax.lang.model.util.ElementScanner14;

public class Student {
    private String name;
    private int rollNo;
    private float CGPA;
    private String Branch;
    private String status = "unoffered";
    Scanner scn = new Scanner(System.in);
    HashMap<String, PriorityQueue<Company>> nameToRegisteredCompanies = new HashMap<>();
    private float highestCtc;

    private void registerForPlacementDrive() {
        System.out.println(this.name + " Registered for the Placement Drive at IIITD!!!!");
        System.out.println("Your details are:");
        this.displayInfo();
    }

    public void comp_av(List<Company> companies) {
        System.out.println("List of All available companies is as follows:");
        int i = 1;
        for (Company company : companies)
        {
            i = i+1;
            
            System.out.println(" ");   
            System.out.println("("+i+")");  
            System.out.println("Company Name: "+ company.comp_name());  
            System.out.println("Company role offering: " + company.comp_role());  
            System.out.println("Company Package: " + company.comp_ctc());  
            System.out.println("Company CGPA criteria: " + company.Comp_minCG());
        }


    }

    public void updateCGPA(float CGPA) {
        this.CGPA = CGPA;
    }

    public void offerReply(String choice) {

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
        date_str(scn.nextLine());

    }

    private Date date_str(String str) {
        
        Date date = new Date();

        return date;
    }

    public int getRollNo() {
        return this.rollNo;
    }

    public String getStudentName() {
        return this.name;
    }

    public void chooseStudent(List<Company> list_comp, p_cell p_cell, HashMap<String, List<Student>> comp_students_s) {
        int ele = 1 ;
        while (ele != 0 && ele != 8)
        {
        
        System.out.println("Welcome " + this.getStudentName());
        System.out.println("!");
        System.out.println("1) Register For Placement Drive");
        System.out.println("2) Register For Company");
        System.out.println("3) Get All available companies");
        System.out.println("4) Get Current Status");
        System.out.println("5) Update CGPA");
        System.out.println("6) Accept offer");
        System.out.println("7) Reject offer");
        System.out.println("8) Back");
        ele = scn.nextInt();
        
        
            
            if (ele==1){
                this.registerForPlacementDrive();
                break;}
                
            else if (ele==2){
                this.comp_av(list_comp);
                this.registerToCompany(list_comp.get(scn.nextInt() - 1),comp_students_s);
                break;

            }   
            else if (ele==3){
                this.comp_av(list_comp);
                break;
                
            }   
            else if (ele==4){
                this.st_status();
                break;
                
            }   
        } 
    }

    void st_status() {
        if(this.status.equals("blocked"))
            System.out.println("You are blocked from placement drive");
        else{
            PriorityQueue<Company> myCompanies=nameToRegisteredCompanies.get(this.name);
            if(myCompanies.isEmpty()){
                System.out.println("Sorry! You have no offers yet");
                return;
            }
            this.status="offered";
            System.out.println("Congratulations "+ this.name +". You have been offered by "+ myCompanies.peek().comp_name() + ".Please accept the offer.");
            this.highestCtc=myCompanies.peek().comp_ctc();
        }
    }

    private void registerToCompany(Company company, HashMap<String, List<Student>> comp_students_s) {
        nameToRegisteredCompanies.putIfAbsent(this.name, new PriorityQueue<>((a,b)->{
            return (int)(b.comp_ctc() - a.comp_ctc());
        }));
        PriorityQueue<Company> companies = nameToRegisteredCompanies.get(this.name);

        if (this.isEligible(company)) {
            companies.add(company);
            System.out.println(
                    "Successfully registered for " + company.comp_role() + " role at " + company.comp_name());
            comp_students_s.putIfAbsent(company.comp_name(),new ArrayList<>());
            List<Student> students=comp_students_s.get(company.comp_name());
            students.add(this);
        }
    }

    private boolean isEligible(Company company) {
        if (this.CGPA < company.Comp_minCG() || this.status.equals("blocked"))
            return false;

        else if (this.status.equals("offered") && this.highestCtc > company.comp_ctc() * 3)
            return false;

        return true;
    }

    public void displayInfo() {
        System.out.print("Name: " + this.name + "\nRollNo: " + this.rollNo + "\nCGPA: " + this.CGPA + "\nBranch: "
                + this.Branch);
        System.out.println();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public float getCGPA() {
        return CGPA;
    }

    public void setCGPA(float cGPA) {
        CGPA = cGPA;
    }

    public String getBranch() {
        return Branch;
    }

    public void setBranch(String branch) {
        Branch = branch;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Scanner getScn() {
        return scn;
    }

    public void setScn(Scanner scn) {
        this.scn = scn;
    }

    public HashMap<String, PriorityQueue<Company>> getNameToRegisteredCompanies() {
        return nameToRegisteredCompanies;
    }

    public void setNameToRegisteredCompanies(HashMap<String, PriorityQueue<Company>> nameToRegisteredCompanies) {
        this.nameToRegisteredCompanies = nameToRegisteredCompanies;
    }

    public float getHighestCtc() {
        return highestCtc;
    }

    public void setHighestCtc(float highestCtc) {
        this.highestCtc = highestCtc;
    }

   
}