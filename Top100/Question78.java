//.Java Program to subtract the two matrices
import java.util.Scanner;

public class Question78 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][m];
        int[][] arr2 = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr2[i][j] = sc.nextInt();
            }
        }
        int[][] submat = new int[n][m];
        System.out.println("Result Matrixs : ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                submat[i][j] = arr[i][j]-arr2[i][j];
                System.out.print(submat[i][j]+" ");
            }
            System.out.println();
        }
    }
}
