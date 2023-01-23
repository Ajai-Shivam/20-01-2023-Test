import java.util.Scanner;

public class Question50 {
    public static void main(String[] args) {
        //print the following pattern.
//        9 9 9 9 9 9 9 9 9
//         8 8 8 8 8 8 8 8
//          7 7 7 7 7 7 7
//           6 6 6 6 6 6
//            5 5 5 5 5
//             4 4 4 4
//              3 3 3
//               2 2
//                1

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter The Nummber oF Rows : ");
        int n = sc.nextInt();
        int print = n;
        for (int i = 0; i < n; i++) {

            for (int j = 1; j <=i ; j++) {
                System.out.print(" ");
            }
            for (int j = n-i; j >0; j--) {
                System.out.print(print+" ");
            }
            print--;
            System.out.println();
        }


    }
}
