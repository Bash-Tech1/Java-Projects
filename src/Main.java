import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String firstNAme,lastName;
        System.out.print("Please Enter Your First Name: ");
        firstNAme = in.next();
        System.out.print("Please Enter Your Last Name: ");
        lastName = in.next();
        Email e1 = new Email(firstNAme, lastName);
        e1.setAlternateEmail();
        e1.emailAndPassword();
        e1.showAll();
    }
}