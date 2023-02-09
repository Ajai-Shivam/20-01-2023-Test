import java.util.ArrayList;
import java.util.Scanner;

public class Question7 {
    public static void main(String[] args) {
        // Subsets
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // Array Size
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        Question7 obj = new Question7();
        ArrayList<Integer> ad = new ArrayList<>(); // Will Be Storing Subsets
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>(); // 2D Arraylist for Storing every subset of the given Array
        obj.subsetsOfAnArray(arr,0,ad,ans);
        System.out.println(ans);
    }
    public void subsetsOfAnArray(int[] arr ,int index , ArrayList<Integer> ad ,ArrayList<ArrayList<Integer>> ans){
        if(index> arr.length){
            return;
        }
        if(index == arr.length){
            ans.add(new ArrayList<>(ad));
            return;
        }
        ad.add(arr[index]);
        subsetsOfAnArray(arr,index+1,ad,ans);
        ad.remove(ad.size()-1);
        subsetsOfAnArray(arr,index+1,ad,ans);

    }
}
