//Java Program to find the frequency of odd & even numbers in the given matrix

import java.util.Scanner;

public class Question84 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][m];
        int odd=0;int even = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            if(arr[i][j]%2==0){
                even++;
            }
            else {
                odd++;
            }

            }
        }
        System.out.println("ODD NUMBER frequency IS : "+odd);
        System.out.println("EVEN NUMBER frequency IS : "+even);
    }
}
