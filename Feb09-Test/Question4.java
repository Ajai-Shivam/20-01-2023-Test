import java.util.ArrayList;
import java.util.Scanner;
public class Question4 {
    static boolean yesornot= true;
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
            obj.solution(check,str,"",ans);
            if(yesornot){
                System.out.println(ans);
            }else{
                System.out.println("Wrong Password");
            }
            t--;
        }
    }
    public void solution (ArrayList<String> check,String str ,String cur,ArrayList<String> ans){

        if(check.contains(cur)){
            ans.add(cur);
            cur ="";
        }
        if(str.length() == 0 && cur.length()>0){
            yesornot = false;
            return;
        }

        solution(check,str.substring(1),cur+str.charAt(0),ans);
    }
}
