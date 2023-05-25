import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class FutureBuilder {
    static Scanner scn;
    static List<Company> list_comp;
    static List<Student> list_st;
    static p_cell p_cell;
    static HashMap<String,List<Student>> comp_students_s;

    public static Scanner getScn() {
        return scn;
    }

    public static void setScn(Scanner scn) {
        FutureBuilder.scn = scn;
    }

    public static List<Company> getCompanyList() {
        return list_comp;
    }

    public static void setCompanyList(List<Company> list_comp) {
        FutureBuilder.list_comp = list_comp;
    }

    public static List<Student> getStudentList() {
        return list_st;
    }

    public static void setStudentList(List<Student> list_st) {
        FutureBuilder.list_st = list_st;
    }

    public static p_cell getPlacementCell() {
        return p_cell;
    }

    public static void setPlacementCell(p_cell p_cell) {
        FutureBuilder.p_cell = p_cell;
    }

    public static HashMap<String, List<Student>> getCompanytoSelectedStudent() {
        return comp_students_s;
    }

    public static void setCompanytoSelectedStudent(HashMap<String, List<Student>> comp_students_s) {
        FutureBuilder.comp_students_s = comp_students_s;
    }

    public static void main(String[] args) {
        scn = new Scanner(System.in);
        list_comp = new ArrayList<>();
        list_st = new ArrayList<>();
        p_cell = new p_cell();
        comp_students_s =new HashMap<>();
        String applicationStart = "Enter FutureBuilder";

        if (applicationStart.equals("Enter FutureBuilder")) {
            int ele=1;
            while(ele==1){
            System.out.println("Welcome to FutureBuilder:");
            System.out.println("1) Enter the Application");
            System.out.println("2) Exit the Application");
            ele=scn.nextInt();
            if (ele == 1)
                futureBuilder();
            }
        }
        scn.close();
    }

    private static void futureBuilder() {
        
        int ele=1;
        while (ele > 0 && ele < 4)
         {
                System.out.println("Choose The mode you want to Enter in:-");
                System.out.println("1) Enter as Student Mode");
                System.out.println("2) Enter as Company Mode");
                System.out.println("3) Enter as Placement Cell Mode");
                System.out.println("4) Return To Main Application");
            ele = scn.nextInt();
            if (ele == 1){
                mo_st();}
            else if(ele == 2){
                mo_comp();}
            else if(ele == 3){
                PCM();}
            }
        } 
    private static void PCM() {
        
        int ele=1;
        while (ele > 0 && ele < 10) {
            System.out.println(
                "Welcome to IIITD Placement Cell");
                System.out.println("1) Open Student Registrations"); 
                System.out.println("2) Open Company Registrations");
                System.out.println("3) Get Number of Student Registrations"); 
                System.out.println("4) Get Number of Company Registrations");
                System.out.println("5) Get Number of Offered/Unoffered/Blocked Students");
                System.out.println("6) Get Student Details");
                System.out.println("7) Get Company Details");
                System.out.println("8) Get Average Package");
                System.out.println("9) Get Company Process Results");
                System.out.println("10) Back");
            ele = scn.nextInt();
                if(ele==1){
                    p_cell.ops_reg();} 
                else if(ele==2){
                    p_cell.opc_reg();}
                else if(ele==5){
                    p_cell.getStudentsStatus(list_st);}
                else if(ele==6){
                    p_cell.getStudentDetails(list_st);}
                else if(ele==7){
                    p_cell.getCompanyDetails(list_comp);}
                else if(ele==8){
                    p_cell.avg_package(list_comp);}
                else if(ele==9){
                    p_cell.comp_process(comp_students_s);}
                
        } 
    }

    private static void mo_comp() {
        
        int ele=1;
        while (ele > 0 && ele < 4){
            System.out.println("Choose the Company Query to perform-");
                System.out.println("1) Add Company and Details");
                System.out.println("2) Choose Company");
                System.out.println("3) Get Available Companies");
                System.out.println("4) Back");
            Company company = new Company();
            ele = scn.nextInt();
            if(ele==1){    
                list_comp.add(company.comp_details());}
            else if(ele==2){
                company.comp_choice(list_comp,p_cell);}
            else if(ele==3){
                company.comp_av(list_comp);}
            }
        }

    private static void mo_st() {
        int ele=1;
        while (ele > 0 && ele < 3){
            System.out.println("Choose the Student Query to perform");
            System.out.println("1) Enter as a Student(Give Student Name, and Roll No.)");
            System.out.println("2) Add students");
            System.out.println("3) Back");
            ele = scn.nextInt();
            if(ele==1){
                    st_en();}
            else if(ele==2){
                    st_add();}
        } 
    }

    private static void st_en() {
        scn.nextLine();
        String[] studentDetail = scn.nextLine().split(" ");
        int rollNo = Integer.valueOf(studentDetail[studentDetail.length-1]);
        for (Student student : list_st)
            if (student.getRollNo() == rollNo) {
                student.chooseStudent(list_comp, p_cell, comp_students_s);
                break;
            }
    }

    private static void st_add() {
        System.out.println("Number of students to add");
        int numStudents = scn.nextInt();
        System.out.println("Please add students Name, Roll No, CGPA, Branch(in order):");
        for (; numStudents > 0; numStudents--) {
            Student student = new Student();
            student.setStudentDetails();
            list_st.add(student);
        }
    }

    
}