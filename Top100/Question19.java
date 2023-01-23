import java.util.Scanner;

public class Question19 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = 28;
        a+=(a++ + ++a) + ((-a) + (-a));
        System.out.println(a);

    }
}
