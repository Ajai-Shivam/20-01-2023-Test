import java.util.Scanner;

public class Question9 {
    public static void main(String[] args) {
        // Pattern Printing

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // Number of Rows
        int[][] arr = new int[n][n];
        Question9 obj = new Question9();
        obj.pattern_Store(arr ,n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j]+ " ");
            }
            System.out.println();
        }
    }
    public void pattern_Store (int[][] arr , int n ){
        int row_begin  = 0,row_end  = n-1;
        int col_begin = 0,col_end = n-1;
        int store = 1;
        while (row_begin<= row_end && col_begin<=col_end){
            for (int i = col_begin; i <= col_end; i++) {
                if(store%2!=0) {
                    arr[row_begin][i] = 1;
                }
            }
            row_begin++;
            for (int i = row_begin; i <=row_end ; i++) {
                if(store%2!=0) {
                    arr[i][col_end] = 1;
                }
            }
            col_end--;
            if(row_begin<=row_end) {
                for (int i = col_end; i >= col_begin; i--) {
                    if(store%2!=0) {
                        arr[row_end][i] = 1;
                    }
                }
                row_end--;
            }
            if (col_begin<=col_end) {
                for (int i = row_end; i >=row_begin; i--) {
                    if(store%2!=0) {
                        arr[i][col_begin] = 1;
                    }
                }
                col_begin++;
            }
            store++;
        }
    }
}
