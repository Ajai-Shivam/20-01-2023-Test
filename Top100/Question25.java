import java.util.Scanner;

public class Question25 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter A Dividend : ");
        int Dividend = sc.nextInt();
        System.out.print("Enter the Divisor : ");
        int Divisor = sc.nextInt();
        System.out.println("reminder : "+Dividend%Divisor);
        System.out.println("Quotient : "+Dividend/Divisor);

    }
}
