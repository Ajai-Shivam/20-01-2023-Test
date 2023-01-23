//
//Java Program to find the sum of each row and each column of a matrix
import java.util.Scanner;

public class Question85 {
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
        System.out.println("Method 1 : ");
        for (int i = 0; i < n; i++) {
            int rowsum = 0;
            int colsum = 0;
            for (int j = 0; j < m; j++) {
                rowsum += arr[i][j];
                colsum += arr[j][i];
            }


            System.out.print("Row " + (i + 1) + " : " + rowsum + "\t");
            System.out.println("column " + (i + 1) + " : " + colsum + "\t");
        }
    method2(arr,n,m);
    }
    public static void method2(int[][] arr,int n ,int m){
        System.out.println("Method 2 : ");
        System.out.println("Row Sum : ");
        for (int i = 0; i < n; i++) {
            int rowsum = 0;
            for (int j = 0; j < m; j++) {
                rowsum+=arr[i][j];
            }
            System.out.println("Row "+(i+1)+" : "+rowsum);
        }
        System.out.println("Column Sum : ");
        for (int i = 0; i < n; i++) {
            int colsum = 0;
            for (int j = 0; j < m; j++) {
                colsum+=arr[j][i];
            }
            System.out.println("Column "+(i+1)+" : "+colsum);
        }
    }
}
