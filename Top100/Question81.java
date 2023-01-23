import java.util.Scanner;

//Java Program to determine whether two matrices are equal
public class Question81 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr= new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }int[][] barr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                barr[i][j] = sc.nextInt();
            }
        }
        boolean flag = true;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(arr[i][j] != barr[i][j]){
                    flag = false;
                    break;
                }
            }
        }

        if(flag)
            System.out.println("Matrices are equal");
        else
            System.out.println("Matrices are not equal");
    }
}

