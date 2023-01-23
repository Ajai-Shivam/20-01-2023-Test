
import java.util.ArrayList;
import java.util.Scanner;

// .Java Program to convert a sentence/paragraph to word(String) array without Using String Funtion
public class Question89 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> Al = new ArrayList<>();
        String s = sc.nextLine();
        int space =-1;
        int i =0;
        while (i<s.length()){
            if(s.charAt(i)==' '){
                Al.add(s.substring(space+1,i));
                space = i;
            }

            i++;
        }
        Al.add(s.substring(space+1,s.length()));
        for (int j = 0; j < Al.size(); j++) {
            System.out.println(Al.get(j));
        }
    }
}
