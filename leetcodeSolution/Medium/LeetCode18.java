class LeetCode18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-3; i++) {
            for (int j = i+1; j < nums.length-2;j++) {
                int k = j + 1;
                int l = nums.length - 1;
                while (k < l) {
                    int front = 0;
                    int back = 0;
                    long sum = (long)nums[i] + nums[j] + nums[k] + nums[l];
                    if (sum > target) {
                        l--;
                    } else if (sum < target) {
                        k++;
                    } else if (sum == target) {
                        List<Integer> ad = new ArrayList<>();
                        ad.add(nums[i]);
                        ad.add(nums[j]);
                        ad.add(nums[k]);
                        front = nums[k];
                        back = nums[l];
                        ad.add(nums[l]);
                        ans.add(ad);
                        while (k < l&& nums[k] == front) {
                            k++;
                        }
                        while (l >= k && nums[l] == back) {
                            l--;
                        }

                    }
                }
                while (j+1< nums.length &&  nums[j]== nums[j+1])
                    j++;
            }
            while (i+1< nums.length &&  nums[i]== nums[i+1])
                i++;
        }
        return ans;
    }
}
