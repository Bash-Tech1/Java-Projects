import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("How many Students u wanna add to the database?");
        Scanner in = new Scanner(System.in);
        int studentsNum;
        lable:
        while (true) {
            try {
                 studentsNum = in.nextInt();
                 if(studentsNum > 0) {
                     break lable;
                 }
                 else{
                     while (studentsNum <= 0){
                         System.out.println("Invalid Input!...please enter a positive number of the students");
                         studentsNum = in.nextInt();
                     }
                     break;
                 }
            } catch (InputMismatchException e) {
                System.out.println("Invalid Input!...please enter the number of the students");
                in.next();
            }
        }
        for (int i = 1; i <= studentsNum; i++){
            String firstName,lastName;
            int year;
            char level;
            System.out.println("Please enter student " + i + " First Name");
            lable:
            while (true) {
                try {
                    firstName = in.next();
                    break lable;
                } catch (InputMismatchException e) {
                    System.out.println("Invalid Input!...please enter the first name of the student " + i);
                    in.next();
                }
            }
            System.out.println("Please enter student " + i + " Last Name");
            lable:
            while (true) {
                try {
                    lastName = in.next();
                    break lable;
                } catch (InputMismatchException e) {
                    System.out.println("Invalid Input!...please enter the last name of the student " + i);
                    in.next();
                }
            }
            System.out.println("Please enter student " + i + " Year");
            lable:
            while (true) {
                try {
                    year = in.nextInt();
                    break lable;
                } catch (InputMismatchException e) {
                    System.out.println("Invalid Input!...please enter the Year of the student " + i);
                    in.next();
                }
            }
            System.out.println("Please enter student " + i + " Level");
            lable:
            while (true) {
                try {
                    level = in.next().charAt(0);
                    break lable;
                } catch (InputMismatchException e) {
                    System.out.println("Invalid Input!...please enter the Level of the student " + i);
                    in.next();
                }
            }
            Student s = new Student(firstName,lastName,year,level);
            System.out.println("How much would u want to charge ur balance?");
            double balance;
            lable:
            while (true) {
                try {
                    balance = in.nextDouble();
                    while (balance < 0){
                        System.out.println("Invalid Input!...please enter a positive number for the student " + i + " balance");
                        balance = in.nextDouble();
                    }
                    break lable;
                } catch (InputMismatchException e) {
                    System.out.println("Invalid Input!...please enter a positive number for the student " + i + " balance");
                    in.next();
                }
            }
            s.setBalance(balance);
            s.payTuition();
            s.showStatus();
        }
    }
}