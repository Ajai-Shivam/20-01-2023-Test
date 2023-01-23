import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;

public class Question9 {
    public static void main(String[] args) throws IOException {
        HashSet<Integer> hs = new HashSet<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(",");
        int[] array1 = new int[arr.length];
        for (int i = 0; i < array1.length; i++) {
            array1[i] = Integer.parseInt(arr[i]);
        }
        arr = br.readLine().split(",");
        int[] array2 = new int[arr.length];
        for (int i = 0; i < array2.length; i++) {
            array2[i] = Integer.parseInt(arr[i]);
        }
        for (int i = 0; i < array1.length; i++) {
            hs.add(array1[i]);
        }
        for (int i = 0; i < array2.length; i++) {
            hs.add(array2[i]);
        }
        ArrayList<Integer> ans = new ArrayList<>(hs);
        System.out.println(ans);

    }
}
