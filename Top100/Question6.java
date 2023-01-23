import java.util.Scanner;

public class Question6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Total Number of Students : ");
        int n = sc.nextInt();
        int[][] arr = new int[5][4];
        int roll = 101;
        for (int i = 0; i < arr.length ; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = roll;
                roll++;
            }
        }
        int group =1;
        for (int i = 0; i < arr[i].length; i++) {
            System.out.println("Group "+group+" :");
            for (int j = 0; j < arr.length ; j++) {
                System.out.println(arr[j][i]);
            }
        group++;
        }
    }
}
