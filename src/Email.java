import java.util.InputMismatchException;
import java.util.Scanner;
public class Email {
    private String firstName;
    private String lastName;
    private String department;
    private int mailCapacity = 1000;
    private String password;
    private int defaultPasswordLength = 10;
    private String alternateEmail;
    private String email;
    private  String companySuffix = ".genTech.com";
    public Scanner in = new Scanner(System.in);
    public Email() {
    }
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = setDepartment();
        this.email = setEmail();
        this.password = setPassword();
    }
    private String setDepartment(){
        System.out.print("What is Your Department?\n0 for Sales\n1 for Development\n2 for Accounting\n3 for none\nYour Answer: ");
        int i = -1;
        try {
             i = in.nextInt();
        }
        catch (InputMismatchException e){
            in.next();
            System.out.print("INVALID INPUT! ");
        }
        while (i < 0 || i  > 3){
            System.out.println("PLEASE ENTER A VALID NUMBER!");
            System.out.print("What is Your Department?\n0 for Sales\n1 for Development\n2 for Accounting\n3 for none\nYour Answer: ");
            try {
                i = in.nextInt();
            }
            catch (InputMismatchException e){
                in.next();
                System.out.print("INVALID INPUT! ");
            }
        }
        if(i == 0) {return "Sales";}
        else if (i == 1){return "Development";}
        else if(i == 2){return "Accounting";}
        else {return "None";}
    }
    private String setPassword(){
        System.out.println("Please enter the length of ur password and it must be more than 10");
        int l = 10;
        try{
             l = in.nextInt();
        }
        catch (InputMismatchException e){
            in.next();
        }
        while (l < 10){
            System.out.println("INVALID INPUT!");
            System.out.print("Please enter the length of ur password and it must be more than 10: ");
            try{
                l = in.nextInt();
            }
            catch (InputMismatchException e){
                in.next();
            }
        }
        this.defaultPasswordLength = l;
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()-_=+[]{};:~";
        char[] password = new char[this.defaultPasswordLength];
        for(int i = 0; i < this.defaultPasswordLength; i++){
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }
    private String setEmail(){
        return this.firstName.toLowerCase() + '.' + this.lastName.toLowerCase() + '@' + this.department.toLowerCase() + this.companySuffix;
    }
    public void setAlternateEmail(){
        System.out.print("Please Enter an Alternative Email: ");
        this.alternateEmail = in.next();
    }
    public void changePassword(String password){
        this.password = password;
    }
    public void changeMailCapacity(int c){
        this.mailCapacity = c;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getDepartment() {
        return department;
    }
    public int getMailCapacity() {
        return mailCapacity;
    }
    public String getPassword() {
        return password;
    }
    public int getDefaultPasswordLength() {
        return defaultPasswordLength;
    }
    public String getAlternateEmail() {
        return alternateEmail;
    }
    public String getEmail() {
        return email;
    }
    public String getCompanySuffix() {
        return companySuffix;
    }
    public void emailAndPassword() {
        String separator = "----------------------------------------";
        System.out.println(separator);
        System.out.printf("%-10s: %s%n", "Email", email);
        System.out.printf("%-10s: %s%n", "Password", password);
        System.out.println(separator + "\n");
    }
    public void showAll() {
        String separator = "----------------------------------------";
        System.out.println(separator);
        System.out.printf("%-20s: %s%n", "First Name", firstName);
        System.out.printf("%-20s: %s%n", "Last Name", lastName);
        System.out.printf("%-20s: %s%n", "Department", department);
        System.out.printf("%-20s: %s%n", "Email", email);
        System.out.printf("%-20s: %s%n", "Alternative Email", alternateEmail);
        System.out.printf("%-20s: %d MB%n", "Email Capacity", mailCapacity);
        System.out.printf("%-20s: %s%n", "Password", password);
        System.out.println(separator + "\n");
    }
}
