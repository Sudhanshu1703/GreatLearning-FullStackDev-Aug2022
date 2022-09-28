import java.util.Random;
import java.util.Scanner;
import java.io.*;



class CredentialService{

  static final String strCompName = "SuperSoft Tech Ltd";
  static final String strCompDomainName = "supersoft.tech";
  static final String strCompEmailDomain = "@%s.supersoft.tech";
  final String tabsCaption = "\t\t\t\t\t\t\t\t\t\t\t";
  static final String tabsHR = "\t\t\t\t\t\t\t\t\t";
  static final String tabsCaptionPipe = "\t\t\t\t\t\t\t\t\t|\t\t";
  static final String doubleLineSeparator = "\n\n";
  enum Department { Technical, Admin, HumanResource, Legal }

  public String interaction(){
    String strConsoleInterface = tabsHR + " *******************************************************************************\n";
    strConsoleInterface += tabsCaption + "Greetings and welcome to " + strCompName + "\n";
    strConsoleInterface += tabsHR + " *******************************************************************************\n";
    strConsoleInterface += tabsCaptionPipe + "You are at Create Credential Service Interface:\t\t\t|\n";
    strConsoleInterface += "\t\t\t\t\t\t\t\t\t ===============================================================================\n";
    strConsoleInterface += doubleLineSeparator;
    strConsoleInterface += "\t\t\t\t\t\t\t\t\t\t\tPlease enter the department from the following list:\n";
    strConsoleInterface += doubleLineSeparator;
    strConsoleInterface += tabsCaption + "1. Technical\n";
    strConsoleInterface += tabsCaption + "2. Admin\n";
    strConsoleInterface += tabsCaption + "3. Human Resource\n";
    strConsoleInterface += tabsCaption + "4. Legal";

    return strConsoleInterface;
  }

  public String generatePassword() throws IOException  {
      Random rand = new Random();

      String str = rand.ints(48, 123)
                .filter(num -> (num<1 || num>34) && (num<37 || num>47) && (num<58 || num>63) && (num<91 || num>96) && (num>122 || num<127))
                .limit(15)
                .mapToObj(c -> (char)c).collect(StringBuffer::new, StringBuffer::append, StringBuffer::append)
                .toString();

      str = str.indexOf("@") == -1 ? new StringBuilder(str).insert(str.length()-8, "@").toString(): str;
      str = str.matches(".*[0-9].*") ? str : new StringBuilder(str).insert(str.length()-5, "8").toString();

      return str; // returns alphanumeric passwords with a capital letter and a special character
  }

  public String generateEmail (String FName, String LName, int Dept) {
    //return (FName+LName+String.format(strCompEmailDomain, Department.values()[Dept-1])).toLowerCase();
    if(Dept<=4 & Dept>0) {
        String email = (FName + LName + String.format(strCompEmailDomain, Department.values()[Dept - 1])).toLowerCase();
        return email;
    } else {
        return "Please select a valid department name";
    }
  }
}

class Employee extends CredentialService {
  String FName, LName;

public Employee(){
      System.out.println("\nStep 1: Enter you First Name : "); // Asks user to enter a value for Fname
      Scanner scan = new Scanner (System.in); // read value's from the console
      FName = validateNameVal(scan);
      System.out.println("FName validated : " + FName);
      scan = null;
      scan = new Scanner (System.in); // read value's from the console
      System.out.println("\nStep 2: Enter you Last Name : ");
      LName = validateNameVal(scan);
      System.out.println("LName validated : " + LName);
}

public Employee(String FName, String LName){
      this.FName = FName;
      this.LName = LName;
}

public String validateNameVal(Scanner sc){
    while (!sc.hasNext("[A-Za-z]+")) {
        System.out.println("\nNope, Invalid value! Please enter aplabets only.");
        sc.next();
    }
    String word = sc.next();
    //System.out.println("Thank you! Got " + word);
    return word;
}

public Integer validateDeptInputVal(Scanner scan){
  Integer tmp = 0;
  while (!scan.hasNextInt()) {
        System.out.println(tabsCaption + "Invalid value entered. Plz enter a number between 1-4 corresponsing your department from the above list displayed");
        scan.next();
  }

  return scan.nextInt();
}

public Integer validateDeptInputVal1(Scanner scan){
  Integer tmp = 0;
  while (scan.hasNextInt() && !(scan.nextInt()>0 && scan.nextInt()<=4)) {
        System.out.println(tabsCaption + "Invalid value entered. Plz enter a number between 1-4 corresponsing your department from the above list displayed");
        scan.next();
  }

  return scan.nextInt();
}

public Integer validateDeptInputVal2(Scanner scan){
  while (scan.hasNextInt() && (scan.nextInt()>0 && scan.nextInt()<=4)) {
        //System.out.println(tabsCaption + "Invalid value entered. Plz enter a number between 1-4 corresponsing your department from the above list displayed");
        scan.next();
  }
  return scan.nextInt();
}

public void processFinalOutput_Depricated(int inputVal){

    System.out.println(doubleLineSeparator + tabsHR + " *******************************************************************************");
    System.out.println(tabsCaption + "Dear " + FName + " your generated credentials are as follows");
    System.out.println(tabsHR + " *******************************************************************************\n");
    System.out.println(tabsCaption + "Email ---> : " + generateEmail(FName,LName,inputVal));
    System.out.println("\n");

    try{
        System.out.println(tabsCaption + "Password ---> : " + generatePassword());
    } catch(Exception ex) {
        System.out.println("Error in Password generation : " + ex);
    }
    System.out.println(doubleLineSeparator + tabsHR + " *******************************************************************************");
}

public void processFinalOutput(int inputVal){

    if(inputVal >0 && inputVal <=4){ // If the Dept value entered by user is between 1 to 4 then this condition will validate
        System.out.println(doubleLineSeparator + tabsHR + " *******************************************************************************");
        System.out.println(tabsCaption + "Dear " + FName + " your generated credentials are as follows");
        System.out.println(tabsHR + " *******************************************************************************\n");
        System.out.println(tabsCaption + "Email ---> : " + generateEmail(FName,LName,inputVal));
        System.out.println("\n");

        try{
            System.out.println(tabsCaption + "Password ---> : " + generatePassword());
        } catch(Exception ex) {
          System.out.println("Error in Password generation : " + ex);
        }
        System.out.println(doubleLineSeparator + tabsHR + " *******************************************************************************");

      } else{ // If the Dept value entered by user is not between 1 to 4 then user will be prompted to enter a correcvt value.

        System.out.println(tabsCaption + "Invalid value entered. Plz enter a number between 1-4 corresponsing your department from the above list displayed");
        Scanner scan = new Scanner (System.in); // read value from the console
        inputVal = validateDeptInputVal(scan); // Validate's the input value from the console
        processFinalOutput(inputVal);
      }
}

public Integer getDepartmentProcessOutput(){
  int inputVal = 0;
  Scanner scan = new Scanner (System.in); // read value from the console

  inputVal = validateDeptInputVal(scan); // Validate's the input value from the console
  if(!(inputVal >0 && inputVal<=4)){
    getDepartmentProcessOutput();
  }
    return inputVal;
}

public static void main(String[] args){
    int inputVal = 0;
    String generatedPwd = "";
    String generatedEmail = "";
    Employee  objEmp1 = new Employee();
    Employee objEmp = new Employee(objEmp1.FName,objEmp1.LName);
    System.out.println(objEmp.interaction()); // Prints the Deparment values on the console
    Scanner scan = new Scanner (System.in); // read value from the console
    inputVal = objEmp.validateDeptInputVal(scan); // Validate's the input value from the console
    objEmp.processFinalOutput(inputVal);
  }

}

