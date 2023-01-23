import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Question10 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(",");
        int[] arr = new int[input.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
        Arrays.sort(arr);
        int[] output = new int[arr.length];
        int max = arr.length-1;
        int min = 0;
        for (int i = 0; i < arr.length; i++) {
            if(i%2==0){
                output[i] =  arr[max];
                max--;
            }
            else {
                output[i] = arr[min];
                min++;
            }
        }
        System.out.println(Arrays.toString(output));
    }
}
