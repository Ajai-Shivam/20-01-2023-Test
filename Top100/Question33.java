import java.util.Scanner;

public class Question33 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter A Character : ");
        char ch = sc.next().charAt(0);
        if(Character.isAlphabetic(ch)){
            System.out.println(ch+" is Alphabet.");
        } else{
            System.out.println(ch+" is not Alphabet.");
        }

    }
}
