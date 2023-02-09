import java.util.Scanner;

public class Question6 {
    public static void main(String[] args) {
        // Rotate A Matrix 90 Degree By 3 Times.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // Matrix Size.
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        int rotations = 3;
        Question6 obj = new Question6();
        obj.rotate90Degree_3times(arr, rotations);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void rotate90Degree_3times(int[][] arr, int rotation) {
        int n = arr.length;
            for (int i = 0; i < n / 2; i++) {
                for (int j = i; j < n - i - 1; j++) {
                    int temp = arr[i][j];
                    arr[i][j] = arr[j][n-i-1];
                    arr[j][n-i-1] = arr[n - i - 1][n - j - 1];
                    arr[n - i - 1][n - j - 1] = arr[n-j-1][i];
                    arr[n - j - 1][i] = temp;
                }
            }
        }

    }
