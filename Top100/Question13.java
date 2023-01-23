import java.util.Scanner;

public class Question13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // getting the length of side.
        System.out.print("Enter the length of side : ");
        double length = sc.nextInt();
        double formula = length*length;
        System.out.println("The area of Square : "+formula);
     }
}
