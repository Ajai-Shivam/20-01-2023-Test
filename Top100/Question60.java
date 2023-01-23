import java.util.Scanner;

// Write a program to find the sum of the series. The series will be like 1 +11 + 111 +
//        1111 +.. n terms.
//        Eg 1: Input:  Input the number of terms : 5
//        Output :
//        1 + 11 + 111 + 1111 + 11111
//        The Sum is : 12345
//        Eg 2: Input:  Input the number of terms : 3
//        Output :
//        1 + 11 + 111
//        The Sum is : 123
public class Question60 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String num = "1";
        long sum = 1;
        System.out.print("1");
        for (int i = 1; i < n; i++) {
            num+=1;
            sum+= Long.parseLong(num);
            System.out.print(" + "+num);

        }
        System.out.println();
        System.out.println("The Sum is : "+sum);
    }
}
