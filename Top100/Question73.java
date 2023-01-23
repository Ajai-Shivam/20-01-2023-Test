import java.util.Scanner;

public class Question73 {
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
        int[][] addedMat = new int[n][m];
        System.out.println("Result Matrixs : ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                addedMat[i][j] = arr[i][j]+arr2[i][j];
                System.out.print(addedMat[i][j]+" ");
            }
            System.out.println();
        }
    }
}
