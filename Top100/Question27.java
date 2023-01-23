import java.util.Scanner;

public class Question27 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter A First Number : ");
        int a = sc.nextInt();
        System.out.print("Enter A Second Number : ");
        int b = sc.nextInt();
        System.out.println("Before Swapping : ");
        System.out.println("a = "+a+"\tb = "+b);
        swap(a,b);
    }
    public static void swap (int a , int b){
        int temp = a;
        a = b;
        b =  temp;
        System.out.println("After Swapping : ");
        System.out.println("a = "+a+"\tb = "+b);
    }
}
