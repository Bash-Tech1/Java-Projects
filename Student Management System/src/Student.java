import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Student {
    private String firstName;
    private String lastName;
    private int year;
    private char level;
    private int id;
    private ArrayList<String> courses;
    private double balance;
    private int tution;
    private String separator = "----------------------------------------";

    public Student(){};
    public Scanner in = new Scanner(System.in);
    public Student(String firstName, String lastName, int year, char level){
        this.firstName = firstName;
        this.lastName = lastName;
        this.year = year;
        this.level = level;
        this.id = generateId();
        this.courses = enrollCourses();
        this.balance = 0;
        this.tution = caclTuition();
    }
    //generate id
    private int generateId(){
        char[] id = new char[5];
        id[0] = this.level;
        String digits = "1234567890";
        for(int i = 1; i < 5; i++){
            int rand =(int) (Math.random() * digits.length());
            id[i] = digits.charAt(rand);
        }
        String str = new String(id);
        return Integer.parseInt(str);
    }
    //enroll courses
    private ArrayList<String> enrollCourses(){
        ArrayList<String>coursesNames = new ArrayList<>();
        ArrayList<String>studentCourses = new ArrayList<>();
        int[] visited = new int[6];
        coursesNames.add("1- for History");
        coursesNames.add("2- for English");
        coursesNames.add("3- for Chemistry");
        coursesNames.add("4- for Computer Science");
        coursesNames.add("5- for Mathematics");
        int num = 0;
        while (!coursesNames.isEmpty() && num != 6) {
            if(num<0 || num > 6){
                System.out.println("Invalid Input!");
                num = 0;
            }
            System.out.println("Select ur courses");
            for (String coursesName : coursesNames) {
                System.out.println(coursesName);
            }
            System.out.println("6- to End");
            try{
                num = in.nextInt();
            }
            catch (InputMismatchException e){
                System.out.println("Invalid Input!");
                in.next();
            }
            if (num == 1) {
                if(visited[1] != 1) {
                    coursesNames.remove("1- for History");
                    studentCourses.add("History");
                }
                else{
                    System.out.println("History Course Already has been Added!");
                }
                visited[1] = 1;
            } else if (num == 2) {
                if(visited[2] != 2) {
                    coursesNames.remove("2- for English");
                    studentCourses.add("English");
                }
                else{
                    System.out.println("English Course Already has been Added!");
                }
                visited[2] = 2;
            } else if (num == 3) {
                if(visited[3] != 3) {
                    coursesNames.remove("3- for Chemistry");
                    studentCourses.add("Chemistry");
                }
                else{
                    System.out.println("Chemistry Course Already has been Added!");
                }
                visited[3] = 3;
            } else if (num == 4) {
                if(visited[4] != 4) {
                    coursesNames.remove("4- for Computer Science");
                    studentCourses.add("Computer Science");
                }
                else{
                    System.out.println("Computer Science Course Already has been Added!");
                }
                visited[4] = 4;
            } else if (num == 5) {
                if(visited[5] != 5) {
                    coursesNames.remove("5- for Mathematics");
                    studentCourses.add("Mathematics");
                }
                else{
                    System.out.println("Mathematics Course Already has been Added!");

                }
                visited[5] = 5;
            }
        }
        return studentCourses;
    }
    //student tuition
    private int caclTuition(){
        return 600 * courses.size();
    }
    private int calcPills(int numberOfCourses){
        return numberOfCourses * 600;
    }
    //pay tuition
    public void payTuition(){
        System.out.println("How many courses u want to pay for?");
        int num = in.nextInt();;
        if(num <= courses.size()){
            if(balance >= calcPills(num)){
                balance -= calcPills(num);
                System.out.println("U have just paid ur pills and ur balance is: " + balance);
                this.tution = tution - calcPills(num);
            }
            else{
                System.out.println("U dont have enough balance ... ur current balance is: " + balance);
            }
        }
        else{
            System.out.println("U just have " + courses.size() + " Courses!");
        }
    }
    public void showStatus(){
        System.out.println(separator);
        System.out.printf("%-20s: %s%n", "First Name", firstName);
        System.out.printf("%-20s: %s%n", "Last Name", lastName);
        System.out.printf("%-20s: %s%n", "ID", id);
        System.out.printf("%-20s: %s%n", "Year", year);
        System.out.printf("%-20s: %s%n", "Level", level);
        System.out.printf("%-20s: %f $%n", "Balance", balance);
        System.out.printf("%-20s: %d $%n", "Tuition", tution);
        System.out.println("Enrolled Courses are:");
        System.out.print("{");
        for(int i = 0; i <courses.size();  i++){
            System.out.print(courses.get(i));
            if(i < courses.size() - 1)
                System.out.print(", ");
        }
        System.out.println("}");
        System.out.println(separator + "\n");
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public char getLevel() {
        return level;
    }

    public void setLevel(char level) {
        this.level = level;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
        System.out.println("U just added " + balance + "$ to ur account");
    }
}
