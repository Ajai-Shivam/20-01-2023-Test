import java.util.Arrays;

public class Insertionsort {
    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1};
        insertion_Sort(arr);
        System.out.println(Arrays.toString(arr));

    }
    public static void insertion_Sort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i-1;
            while (j>=0 && arr[j]>key){
                arr[j+1] =  arr[j];
                j--;
            }
            arr[j+1] = key;
        }
    }
}
