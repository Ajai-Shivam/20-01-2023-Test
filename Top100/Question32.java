import java.util.Scanner;

public class Question32 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter The NUmber to Check If it is +ve or -ve : ");
        int num = sc.nextInt();
        if(num>0){
            System.out.println("The Number "+num+" is : Positive");
        }else if(num<0){
            System.out.println("The Number "+num+" is : Negative");
        }
    }
}
