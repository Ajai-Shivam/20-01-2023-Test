import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Question47 {
    public static void main(String[] args) {
        // print following pattern
//            1
//           1 1
//          1 2 1
//         1 3 3 1
//        1 4 6 4 1

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter The Nummber oF Rows : ");
        int n = sc.nextInt();
        ArrayList<ArrayList<Integer>>arr = new ArrayList<>();
        ArrayList<Integer> prev = new ArrayList<>();
        prev.add(1);
        arr.add(prev);

        for (int i = 2; i <= n; i++) {
            ArrayList<Integer> cur = new ArrayList<>();
            cur.add(1);
            for (int j = 1; j <=i-2 ; j++) {
                cur.add(prev.get(j-1)+prev.get(j));

            }
            cur.add(1);
            arr.add(cur);
            prev = cur;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n-i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < arr.get(i).size(); j++) {
                System.out.print(arr.get(i).get(j)+" ");
            }
            System.out.println();
        }
    }
}
