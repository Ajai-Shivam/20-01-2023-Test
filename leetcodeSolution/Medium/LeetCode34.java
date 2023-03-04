class LeetCode34{
    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        int mid =0;
        int[] ans = new int[2];
        ans[0] = -1;
        ans[1] = -1;
        int j =0;
        int k =0;
        while(left<=right){
            mid = (left+right)/2;
            if( nums[mid] == target ){
                j = mid;
                k = mid;
                while(j<nums.length){
                    if(nums[j] == target){
                        j++;
                    }else{
                        break;
                    }
                }
                while(k>=0){
                    if(nums[k] == target){
                        k--;
                    }else{
                        break;
                    }
                }
                ans[0] = k+1;
                ans[1] = j-1;
                return ans;
            }
            else if (nums[mid] > target){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return ans;
    }
}
