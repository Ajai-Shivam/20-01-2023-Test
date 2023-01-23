// Write a program to print the following output for the given input. You can assume
//        the string is of odd length
//        Eg 1:  Input: 12345
//        Output:
//        1       5
//          2   4
//            3
//          2   4
//        1       5
import java.util.Scanner;

public class Question57 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
               if(i==j || j==n-i+1){
                   System.out.print(j);
               }else {
                   System.out.print(" ");
               }
            }
            System.out.println();
        }
    }
}
