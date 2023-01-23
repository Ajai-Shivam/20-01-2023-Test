import java.util.Scanner;

public class Question18 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println(++a-b);
        System.out.println(a%b++);
        System.out.println(a*=b+5);
        int x = 65>>>2;
        System.out.println(x);
    }
}
