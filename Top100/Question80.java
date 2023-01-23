//80.Java Program to determine whether a given matrix is a sparse matrix

import java.util.Scanner;

public class Question80 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j]= sc.nextInt();
            }
        }

        method1(arr,n,m);
    }
    public static void method1(int[][] arr, int n,int m ) {
        System.out.println("Method 1 : ");
        int total = (n*m)/2;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(arr[i][j]==0){
                    count++;
                }
            }
        }
        if(count>total){
            System.out.println("It is A Sparse Matrix");
        }else{
            System.out.println("It is not A sparse MAtrixs");
        }
    }

}




