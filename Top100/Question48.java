import java.util.Scanner;

public class Question48 {
    public static void main(String[] args) {
        //print the following pattern.

//                        9
//                      8 9 8
//                    7 8 9 8 7
//                  6 7 8 9 8 7 6
//                5 6 7 8 9 8 7 6 5
//              4 5 6 7 8 9 8 7 6 5 4
//            3 4 5 6 7 8 9 8 7 6 5 4 3
//          2 3 4 5 6 7 8 9 8 7 6 5 4 3 2
//        1 2 3 4 5 6 7 8 9 8 7 6 5 4 3 2 1

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter The NUmber oF Rows : ");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n-i; j++) {
                System.out.print("  ");
            }
            for (int j = n-i; j <=n ; j++) {
                System.out.print(j+" ");
            }
            for (int j = n-1; j>=n-i  ; j--) {
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }
}
