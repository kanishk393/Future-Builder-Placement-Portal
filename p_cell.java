import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class p_cell {
    
    private Date date_str(String str) {
        
        Date date = new Date();

        return date;
    } 

    Date companyOpenDate;
    Date studentOpenDate;
    Date companyCloseDate;
    Date studentCloseDate;

    private Scanner scn;

    public p_cell() {
        scn = new Scanner(System.in);
    }

    public void ops_reg() {
        System.out.println("Fill in the details:-");
        System.out.println("1) Set the Opening time for Student registrations");
        System.out.println("2) Set the Closing time for Student registrations");     
        studentOpenDate = date_str(scn.nextLine());
        studentCloseDate = date_str(scn.nextLine());
    }

    public void opc_reg() {
        System.out.println("Fill in the details:-");
        System.out.println("1) Set the Opening time for company registrations");
        System.out.println("2) Set the Closing time for company registrations");   
        companyOpenDate = date_str(scn.nextLine());
        companyCloseDate = date_str(scn.nextLine());

    }

    public void comp_process(HashMap<String, List<Student>> comp_students_s) {
        int temp=1;
        System.out.println("\nEnter Company Name: ");
        String company=scn.nextLine();
        List<Student> selectedStudents=comp_students_s.get(company);
        
        for(Student student:selectedStudents){
            temp = temp+1;
            System.out.print(temp +" ");
            student.displayInfo();
            
        }
    }

    public void getStudentsStatus(List<Student> list_st) {
        
    }

    public void getStudentDetails(List<Student> list_st) {
        int temp = 1;
        for (Student student : list_st)
         {
            temp=temp+1;
            System.out.print(temp + ") ");
            student.displayInfo();
            System.out.println();
        }
    }

    public void getCompanyDetails(List<Company> list_comp) {
        int i = 1;
        for (Company company : list_comp)
            {i=i+1;
            System.out.println(""+i);
            System.out.println("Company Name: " + company.comp_name());
            System.out.println("Company role offering: "+ company.comp_role());
            System.out.println("Company Package" + company.comp_ctc());
            System.out.println("Company CGPA criteria" + company.Comp_minCG());}
            
                            

    }

    public void avg_package(List<Company> list_comp) {
        double avg = 0;
        for (Company company : list_comp)
            avg += company.comp_ctc();
        System.out.println("The average package is " + avg / list_comp.size());
    }

    public Date getCompanyOpenDate() {
        return companyOpenDate;
    }

    public void setCompanyOpenDate(Date companyOpenDate) {
        this.companyOpenDate = companyOpenDate;
    }

    public Date getStudentOpenDate() {
        return studentOpenDate;
    }

    public void setStudentOpenDate(Date studentOpenDate) {
        this.studentOpenDate = studentOpenDate;
    }

    public Date getCompanyCloseDate() {
        return companyCloseDate;
    }

    public void setCompanyCloseDate(Date companyCloseDate) {
        this.companyCloseDate = companyCloseDate;
    }

    public Date getStudentCloseDate() {
        return studentCloseDate;
    }

    public void setStudentCloseDate(Date studentCloseDate) {
        this.studentCloseDate = studentCloseDate;
    }

    public Scanner getScn() {
        return scn;
    }

    public void setScn(Scanner scn) {
        this.scn = scn;
    }

}
