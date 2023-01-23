import java.util.Scanner;

// Bitwise Opertor
public class Question4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        System.out.println("x&y : "+(x&y));
        System.out.println("x^y : "+(x^y));
        System.out.println("x|y : "+(x|y));
        System.out.println("-x : "+(~x));
        System.out.println("Right Shift : "+(x>>2));
        System.out.println("Left Shift : "+(x<<1));
        System.out.println("Unsigned Right Shift : "+(x>>>2)) ;
    }
}
