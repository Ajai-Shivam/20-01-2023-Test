import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Scanner;

public class Question40 {
    public static void main(String[] args) throws IOException {
        //Java Program to print the number of elements present in an array
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter The Array Element with a Space : ");
        String[] arr = br.readLine().split(" ");
        System.out.println(arr.length);
    }
}
