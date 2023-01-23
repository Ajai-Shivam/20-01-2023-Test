import java.util.Scanner;
// Write a program to print the following pattern based on the alphabet.
//        Example 1:
//        Input: E
//        Output:
//        EEEEE
//        DDDD
//        CCC
//        BB
//        A
public class Question5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char c = sc.next().charAt(0);
        int n = c-64;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n-i; j++) {
                System.out.print(c);
            }
            System.out.println();
            c--;
        }
    }
}
