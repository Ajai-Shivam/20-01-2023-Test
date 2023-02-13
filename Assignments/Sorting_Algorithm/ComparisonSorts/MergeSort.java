import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr2 =  {5,4,3,2,1};
        divideandconque(arr2);
        System.out.println(Arrays.toString(arr2));

    }
    public static void divideandconque(int[] nums){
        if(nums.length == 1){
            return;
        }
        int[] left = Arrays.copyOfRange(nums,0,nums.length/2);
        divideandconque(left);
        int[] right = Arrays.copyOfRange(nums,nums.length/2,nums.length);
        divideandconque(right);
        merge_sort(left,right,nums);

    }
    public static void merge_sort(int [] arr ,int[] arr2,int[] nums){
        int i = 0 ,j= 0, k = 0;
        while (i<arr.length && j<arr2.length){
            if(arr[i]<arr2[j]){
                nums[k] = arr[i];
                i++;

            }else{
                nums[k] = arr2[j];
                j++;
            }
            k++;
        }
        while (i<arr.length){
            nums[k] = arr[i];
            i++;
            k++;
        }
        while (j<arr2.length){
            nums[k] = arr2[j];
            j++;
            k++;
        }
    }
}
