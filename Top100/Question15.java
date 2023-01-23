import java.util.Scanner;

public class Question15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Area = 2πrh + 2πr2.
        // getting the height and radius of cylinder.
        System.out.print("Enter the Height of Cylinder : ");
        double height = sc.nextDouble();
        System.out.print("Enter the Radius of Cylinder : ");
        double radius = sc.nextDouble();
        double Pi = 3.14;
        double formula = (2*Pi*radius*height)+(2*Pi*(radius*radius));
        System.out.println("The Area Of Cylinder : "+formula);
    }
}
