class LeetCode229 {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        Arrays.sort(nums);
        int i = 0,j=0;
        int count =0;
        while(i< nums.length && j< nums.length){
            if(nums[i]==nums[j]){
                count++;
                j++;
            }else if(nums[i]!=nums[j]){
                if(count>(nums.length/3)){
                    ans.add(nums[i]);
                }
                i=j;
                j=i;
                count = 0;
            }
            if(j== nums.length){
                if(count>0){
                    if(count>(nums.length/3)){
                        ans.add(nums[i]);
                    }
                }
                i++;
                j=j;
            }
        }
        return ans;
    }
    }
