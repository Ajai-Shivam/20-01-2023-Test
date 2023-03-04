class LeetCode45 {
    public int jump(int[] nums) {
         int[] arr = new int[nums.length];
        for(int i =nums.length-2;i>=0;i--){
            int min = Integer.MAX_VALUE;
            int range = Math.min(nums.length-1,i+nums[i]);
            for(int j=i+1;j<=range;j++){
                min = Math.min(min,arr[j]);
            }if(min!=2147483647){
                arr[i] =min+1;
            }else{
                arr[i] = min;
            }

        }
        return arr[0];
    }
}
