import java.util.ArrayList;
import java.util.Scanner;

public class Question4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t>0){
            ArrayList<String> check = new ArrayList<>();
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                check.add(sc.next());
            }
            String str = sc.next();
            Question4 obj = new Question4();
            ArrayList<String> ans = new ArrayList<>();
            obj.solution(check,str,"");
            t--;
        }
    }
    public void solution (ArrayList<String> check,String str ,String cur){

        if(check.contains(cur)){
            System.out.print(cur+" ");
            cur ="";
        }
        if(str.length() == 0){
            System.out.println("WRONG PASSWORD");
            return;
        }

        solution(check,str.substring(1),cur+str.charAt(0));
    }
}
