class LeetCode16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int minimum_diff = Integer.MAX_VALUE;
        int answer = 0;
        for(int i = 0;i<nums.length-2;i++){
            int j = i+1,k = nums.length-1;
            while(j<k){
                int current_sum = nums[i]+nums[j]+nums[k];
                if(current_sum == target){
                    return current_sum;
                }
                if(Math.abs(current_sum - target)<minimum_diff){
                    answer = current_sum;
                    minimum_diff = Math.abs(current_sum - target);
                }
                if(target<current_sum)k--;
                if(target>current_sum)j++;
            }
        }
    return answer;
    }
}
