import java.util.Scanner;

public class Question2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter A Letter : ");
        char start = sc.next().charAt(0);
        char end = 'Z';
        for (char i = start; i <=end; i++) {
            System.out.print(i);
        }

    }
}
