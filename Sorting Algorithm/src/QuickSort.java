import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1};
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr, int low, int high) {
       if(low<high) {
           int partindex = partion(arr, low, high);
           quickSort(arr,low,partindex-1);
           quickSort(arr,partindex+1,high);
       }
    }

    private static int partion(int[] arr, int low, int high) {
        int pivot = arr[low];
        int i = low;
        int j = high;

        while (i < j) {
            while (i < j && arr[i] <= pivot) {
                i++;
            }
            while (j > low && arr[j] > pivot) {
                j--;
            }
            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        arr[low] = arr[j];
        arr[j] = pivot;
        return j;
    }


}
