//Java Program to display the transpose matrix

import java.util.Arrays;
import java.util.Scanner;

public class Question76 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        method1(arr, n,m);
        method2(arr, n,m);
    }


    public static void method1(int[][] arr, int n,int m) {
        System.out.println("Method 1 : ");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[j][i]+" ");
            }
            System.out.println();
        }
    }
    public static void method2(int[][] arr, int n,int m) {
        // if it is an n*n matrics it works else it won't work...
        for (int i = 0; i < m; i++)
            for (int j = i + 1; j < n; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        System.out.println("Method 1 : ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}

