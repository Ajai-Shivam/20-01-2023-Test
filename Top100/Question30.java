import java.util.Scanner;

public class Question30 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter The Three Numbers with Space in between : ");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        System.out.print("The Max Number Among Three : ");
        int max = Math.max(c,Math.max(a,b));
        System.out.println(max);
    }
}
