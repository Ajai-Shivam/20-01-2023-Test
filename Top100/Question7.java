import java.util.Scanner;

public class Question7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                if(i==j || j==s.length()-i-1){
                    System.out.print(s.charAt(i));
                }
                else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
