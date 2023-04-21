package Stack;

import java.util.Scanner;

public class SeatingPosition {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = n%6;
        switch (ans){
            case 1:
                System.out.println("WS");
                break;
                case 0 :
                    System.out.println("WS");
                    break;
            case 3:
                System.out.println("AS");
                break;
            case 4:
                System.out.println("AS");
                break;
            case 5:
                System.out.println("MS");
                break;
            case 2:
                System.out.println("MS");
                break;

        }
    }
}
