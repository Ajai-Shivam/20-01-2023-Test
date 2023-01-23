import java.util.Scanner;

public class Question34 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter The Number : ");
        int n  = sc.nextInt();
        int sum = 0;
        int number = n;
        while (n>0){
            sum+=n;
            n--;
        }
        String digit = Integer.toString(sum);
        System.out.println("Sum of "+number+" is : "+sum);
        System.out.println("Largest Digit : "+ digit.length());
    }
}
