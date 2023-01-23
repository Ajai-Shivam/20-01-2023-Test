//Write a program to print the following pattern for the given input number.
//        Eg 1:  Input: 4
//        Output:
//        ********
//        ***__***
//        **____**
//        *______*
//        **____**
//        ***__***
//        ********


import java.util.Scanner;

public class Question58 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n*2; i++) {
            System.out.print("*");
        }
        System.out.println();
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n-i; j++) {
                System.out.print("*");
            }
            for (int j = 0; j < i; j++) {
                System.out.print("  ");
            }
            for (int j = 0; j < n-i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i = 2; i < n; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            for (int j = 0; j<n-i; j++) {
                System.out.print("  ");
            }
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();

        }
        for (int i = 0; i < n*2; i++) {
            System.out.print("*");
        }
    }
}
