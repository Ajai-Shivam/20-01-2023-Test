import java.util.Arrays;

public class Selectionsort {
    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1};
        selection_sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void selection_sort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i+1; j < arr.length; j++) {
                if(arr[j]<arr[i]){
                    min = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }
}
