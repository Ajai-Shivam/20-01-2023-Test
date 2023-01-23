import java.util.Scanner;

public class Question17 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter The Radius Of Outter Circle : ");
        double outtercircle = sc.nextDouble();
        System.out.print("Enter The Radius Of Innear Circle : ");
        double innercircle = sc.nextDouble();
        double pi = 3.14;
        outtercircle*=outtercircle;
        innercircle*=innercircle;
        double area = pi*(outtercircle-innercircle);
        System.out.println("Area Of the Concentric Circle : "+area);
    }
}
