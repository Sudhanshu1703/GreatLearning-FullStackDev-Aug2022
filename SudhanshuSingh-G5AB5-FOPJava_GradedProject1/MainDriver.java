

/**
 *
 * @author SUDHANSHU
 * @group  G5AB5
 *
 */

class SuperDepartment{
    String departmentName(){
        return "Super Department";
    }
    String getTodaysWork(){
        return "No Work as of now";
    }
    String getWorkDeadline(){
        return "Nil";
    }
    String isTodayAHoliday(){
        return "Today is not a holiday";
    }
}
 
class AdminDepartment extends SuperDepartment{
    @Override
    String departmentName(){
        return "Admin Department";
    }
    
    @Override
    String getTodaysWork(){
        return "Complete your documents Submission";
    }
    
    @Override
    String getWorkDeadline(){
        return "Complete by EOD";
    }
}

class HrDepartment extends SuperDepartment{
    @Override
    String departmentName(){
        return "Hr Department";
    }
    
    @Override
    String getTodaysWork(){
        return "Fill today's timesheet and mark your attendance";
    }
    
    @Override
    String getWorkDeadline(){
        return "Complete by EOD";
    }
    
    String doActivity(){
        return "team Lunch";
    }
}

class TechDepartment extends SuperDepartment{
    @Override
    String departmentName(){
        return "Tech Department";
    }
    
    @Override
    String getTodaysWork(){
        return "Complete coding of module";
    }
    
    @Override
    String getWorkDeadline(){
        return "Complete by EOD";
    }
    String getTechStackInformation(){
        return "core Java";
    }
}


public class MainDriver {

    public static void main(String[] args) {
        
        AdminDepartment objAdimn = new AdminDepartment();
        
        System.out.println("*******************************************************************************");
        System.out.println("\t\t\tDepartment Functionalities");
        System.out.println("*******************************************************************************");
        System.out.println("\n");
        
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("\t\t\t Admin Department Functionalities");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("Department Name : " + objAdimn.departmentName());
        System.out.println("Todays Work     : " + objAdimn.getTodaysWork());
        System.out.println("Work Deadline   : " + objAdimn.getWorkDeadline());
        System.out.println("Is Holiday      : " + objAdimn.isTodayAHoliday());
        System.out.println("\n");
        
        System.out.println("--------------------------------------------------------------------------------");        
        System.out.println("\t\t\t Hr Department Functionalities");
        System.out.println("--------------------------------------------------------------------------------");
        HrDepartment objHr = new HrDepartment();
        System.out.println("Department Name : " + objHr.departmentName());
        System.out.println("Todays Work     : " + objHr.getTodaysWork());
        System.out.println("Work Deadline   : " + objHr.getWorkDeadline());
        System.out.println("Do Activity     : " + objHr.doActivity());
        System.out.println("Is Holiday      : " + objAdimn.isTodayAHoliday());
        System.out.println("\n");

        System.out.println("--------------------------------------------------------------------------------");        
        System.out.println("\t\t\t Tech Department Functionalities");
        System.out.println("--------------------------------------------------------------------------------");
        TechDepartment objTech = new TechDepartment();
        System.out.println("Department Name : " + objTech.departmentName());
        System.out.println("Todays Work     : " + objTech.getTodaysWork());
        System.out.println("Work Deadline   : " + objTech.getWorkDeadline());
        System.out.println("Tech Stack Info : " + objTech.getTechStackInformation());
        System.out.println("Is Holiday      : " + objAdimn.isTodayAHoliday());
        System.out.println("\n********************************************************************************");
    }
}
