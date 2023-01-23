import java.util.Scanner;

public class Question14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // getting the length and Width of Rectangle.
        System.out.print("Enter the length of Rectangle : ");
        double length = sc.nextDouble();
        System.out.print("Enter the Width of Rectangle : ");
        double width = sc.nextDouble();
        double formula = length*width;
        System.out.println("The area of Rectangle : "+formula);
    }
}
