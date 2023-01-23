//x1=++x – x++ + –x

import java.util.Scanner;

public class Question23 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = 5;
        int x1 = ++x - x++ + (-x);
        System.out.println(x1);

    }
}
