import java.util.Scanner;
// write a program to find the difference between the given number and it's reverse
//         number.
//         Example 1: Input : 12345
//         Output : 12345 - 54321 = -41976
public class Question3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter The Number : ");
        int n = sc.nextInt();
        int num = n;
        int reverse =0;
        while (num>0){
            reverse = (reverse*10)+(num%10);
            num/=10;
        }
        System.out.println();
        System.out.println(n+" - "+reverse+" = "+(n-reverse));
    }
}
