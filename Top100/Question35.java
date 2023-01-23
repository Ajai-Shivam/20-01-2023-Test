import java.util.Scanner;

public class Question35 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter The Number : ");
        int num = sc.nextInt();
        int product = 1;
        for (int i =1;i<=num;i++){
            product*=i;

        }
        System.out.println("The Factorial Of The Number "+num+" is : "+product);
        int sum =0;
        while(product>0){
            int digit = product%10;
            sum += digit;
            product/=10;
        }
        System.out.println("The sum of Digit Of Factorial : "+sum);
    }
}
