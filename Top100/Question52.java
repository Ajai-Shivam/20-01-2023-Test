//Using Recursion reverse the string such as
//        Eg 1:  Input: one two three
//        Output: three two one
//        Eg 2:  Input: I love india
//        Output: india love I


import java.util.Scanner;

public class Question52 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter The String To be Reversed : ");
        String s = sc.nextLine();
        String ans  = reverse(s);
        System.out.println(ans);
    }
    // string was recursively reversed using this function.
    public static String reverse(String s){
        for (int i = s.length()-1; i >=0 ; i--) {
            if(s.charAt(i) == ' '){
                return s.substring(i+1,s.length())+" "+reverse(s.substring(0,i));
            }
        }
        return s;


    }

}
