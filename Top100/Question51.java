import java.util.Scanner;

public class Question51 {
    public static void main(String[] args) {
        //Write a program to display the number in reverse order without use of String functions.
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter The Number to be reversed : ");
        int num = sc.nextInt();
        //reversing
        int rev = 0;
        while (num>0){
            rev = (rev*10)+(num % 10);
            num/=10;
        }
        System.out.println("Reversed Number : "+rev);
    }

}
