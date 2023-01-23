//Write a program to make such a pattern like a pyramid with numbers increased by 1.
//        Eg:  Input : 10
//        Output:
//           1
//          2 3
//         4 5 6
//        7 8 9 10

import java.util.Scanner;

public class Question56 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int num = 0;
        while(n>0){
            n-=num;
            num++;
        }
        int print = 1;
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num-i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < i; j++) {
                System.out.print(print+" ");
                print++;
            }
            System.out.println();
        }

    }
}
