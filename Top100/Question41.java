import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Question41 {
    public static void main(String[] args) throws IOException {
        //Java Program to copy all elements of one array into another array
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        String[] b = arr.clone();
        System.out.println("First Array : ");
        System.out.println(Arrays.toString(arr));
        System.out.println("Copied Array : ");
        System.out.println(Arrays.toString(b));


    }
}
