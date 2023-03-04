class LeetCode75 {
    public void sortColors(int[] nums) {
        if(nums.length == 1){
            return;
        }
        int[] left = Arrays.copyOfRange(nums,0,nums.length/2);
        sortColors(left);
        int[] right = Arrays.copyOfRange(nums,nums.length/2,nums.length);
        sortColors(right);
        merge_sort(left,right,nums);
    }
    public void merge_sort(int [] arr ,int[] arr2,int[] nums){
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
