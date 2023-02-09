import java.util.Arrays;
import java.util.Scanner;

public class Question3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // Size of the Expenditure array.
        int d = sc.nextInt();
        int[] expenditure = new int[n];
        for (int i = 0; i < n; i++) {
            expenditure[i] = sc.nextInt();
        }
        int[] median_check = Arrays.copyOfRange(expenditure,0,d);
        Arrays.sort(median_check);
        double median = 0;
        if(d%2==0){ // finding median
            median = (double)(median_check[d/2]+median_check[(d/2)-1])/2;
        }else{
            median = (double)median_check[d/2];
        }
        int count = 0;
        for (int i = d; i <expenditure.length ; i++) {
            if((double)expenditure[i]>=median*2){
                count++;
            }
        }
        System.out.println(count);
    }
}
