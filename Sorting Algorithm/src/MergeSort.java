import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1};
        divideAndConq(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    private static void divideAndConq(int[] arr,int low,int high) {
        if(low >= high){
            return;
        }
        int mid = (low+high)/2;

        divideAndConq(arr,low,mid);
        divideAndConq(arr,mid+1,high);
        merge(arr,low,mid,high);
    }

    private static void merge(int[] arr, int low, int mid, int high) {
        int i = low;
        int j = mid+1;
        int k = 0;
        int[] mix = new int[(high-low)+1];
        while (i<=mid && j<=high){
            if(arr[j]<arr[i]){
                mix[k] = arr[j];
                j++;
            }else{
                mix[k] = arr[i];
                i++;
            }
            k++;
        }
        while (i<=mid){
            mix[k] = arr[i];
            k++;
            i++;
        }

        while (j<=high){
            mix[k] = arr[j];
            k++;
            j++;
        }
        for (int l = 0; l <mix.length; l++) {
            arr[low+l] = mix[l];
        }
    }
}
