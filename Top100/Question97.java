import java.util.Arrays;
import java.util.Scanner;

//Java program to find a character in a given string using binary search
public class Question97 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        char c = sc.next().charAt(0);
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        int start = 0;
        int end = arr.length-1;
        while (start<end){
            int mid = (start+end)/2;
            if(arr[mid]==c){
                System.out.println("Index : "+mid);
                break;
            } else if (arr[mid]<c) {
                start= mid+1;
            }
            else if(arr[mid]>c) {
                end = mid-1;
            }
        }

    }
}
