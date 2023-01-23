import java.util.Scanner;

public class Question49 {
    public static void main(String[] args) {

        //print the following pattern.

//        * * * * * * * * *
//         * * * * * * * *
//          * * * * * * *
//           * * * * * *
//            * * * * *
//             * * * *
//              * * *
//               * *
//                *

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter The Number oF Rows : ");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <=i ; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < n-i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
