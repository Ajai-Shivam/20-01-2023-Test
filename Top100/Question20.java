//x = x++ * 2 + 3 * –x;

import java.util.Scanner;

public class Question20 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        x = x++ * 2 + 3 * -3;
        System.out.println(x);
    }
}
