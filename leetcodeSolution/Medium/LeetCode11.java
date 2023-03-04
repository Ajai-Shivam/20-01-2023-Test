class LeetCode11 {
    public int maxArea(int[] height) {
        int left = 0,right = height.length-1,water = 0;
        while(left<right){
            int min = Math.min(height[left],height[right]);
            water = Math.max(min*(right-left),water);
            if(height[left]>height[right]){
                right--;
            }else{
                left++;
            }
        }
    return water;
    }
}
