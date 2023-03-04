class LeetCode55 {
    public boolean canJump(int[] nums) {
        int last_pos = nums[nums.length-1];
        for(int i =nums.length-1;i>=0;i--){
            if(i+nums[i]>= last_pos){
                last_pos = i;
            }
        }
        if(last_pos == 0){
            return true;
        }
        return false;
    }
}
