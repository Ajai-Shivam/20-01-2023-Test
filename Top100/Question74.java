//Java Program to find the product of two matrices
import java.util.Arrays;
import java.util.Scanner;

public class Question74 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] Matrix1 = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Matrix1[i][j] = sc.nextInt();
            }
        }
        int n1 = sc.nextInt();
        int m1 = sc.nextInt();
        int[][] Matrix2 = new int[n1][m1];
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < m1; j++) {
                Matrix2[i][j]= sc.nextInt();
            }
        }
        int[][] result = new int[n][m1];
        if(n1!=m){
        System.out.println("This Two MAtrix Cannot be Multiplied");
    }


    else {
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m1; j++){
                for(int k = 0; k < n1; k++){
                    result[i][j] = result[i][j] + Matrix1[i][k] * Matrix2[k][j];
                }
            }
        }
    }
        System.out.println("Result of two matrices: ");
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m1; j++){
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}
    

