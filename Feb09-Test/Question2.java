import java.util.*;

public class Question2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<String> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(sc.next());
        }
        ArrayList<String> changed  = new ArrayList<>(arr);
        Collections.sort(changed);
        for (int i = 0; i < n; i++) {
            if(arr.indexOf(changed.get(i))<n/2){
                System.out.print("- ");
            }else{
                System.out.print(changed.get(i).substring(1)+" ");
            }
        }

    }
}
