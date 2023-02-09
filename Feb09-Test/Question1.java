import java.util.Arrays;
import java.util.Scanner;

public class Question1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] cost = new int[n];
        for (int i = 0; i < n; i++) {
            cost[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        int i = 0; int j =i+1;
        while (i<cost.length-1){
            int cur_sum = cost[i]+cost[j];
            if(cur_sum == m && i!=j){
                System.out.println("["+(i+1)+" , "+(j+1)+"]");
                cur_sum = 0;
                i++;
                j = i+1;
            }
            j++;
            if(j>= cost.length){
                i++;
                j = i+1;
                cur_sum=0;
            }
        }
    }
}
