import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
class Student{
    int rollno;
    String name;
    static String college = "ITS";
    static void change(){
        college = "BBDIT";
    }
    Student(int r, String n){
        rollno = r;
        name = n;
    }
    void print()
    {
        System.out.println(rollno+" "+name+" "+college);
    }
}
public class Question8{
    public static void main(String args[]){
        Student.change();
        Student s1 = new Student(111,"Karan");
        Student s2 = new Student(222,"Aryan");
        Student s3 = new Student(333,"Sonoo");
        s1.print();
        s2.print();
        s3.print();
    }
}