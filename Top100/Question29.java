import java.util.Scanner;

public class Question29 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a Character : ");
        char ch = sc.next().charAt(0);
        switch (ch){
            case 'A':
                System.out.println(ch+" is Vowel");
                break;

            case 'e' :
                System.out.println(ch+" is Vowel");
                break;
            case 'E':
                System.out.println(ch+" is Vowel");
                break;

            case 'I' :
                System.out.println(ch+" is Vowel");
                break;
            case 'i':
                System.out.println(ch+" is Vowel");
                break;

            case 'O' :
                System.out.println(ch+" is Vowel");
                break;
            case 'o':
                System.out.println(ch+" is Vowel");
                break;

            case 'u' :
                System.out.println(ch+" is Vowel");
                break;
            case 'U':
                System.out.println(ch+" is Vowel");
                break;
            default:
                System.out.println(ch+" is Consonant");
        }

    }
}
