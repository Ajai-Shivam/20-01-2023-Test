import java.util.Scanner;

//Write a program to print the alphabet 'C' with the stars based on the given numbers
//        ****
//        *
//        *
//        ****
public class Question55 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.print("*");
        }
        System.out.println();
        for (int i = 0; i <n/2 ; i++) {
            System.out.println("*");
        }
        for (int i = 0; i < n; i++) {
            System.out.print("*");
        }
    }
}
