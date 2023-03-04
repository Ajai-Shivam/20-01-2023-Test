class LeetCode40 {
    public List<List<Integer>> combinationSum2(int[] arr, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ad = new ArrayList<>();
        Arrays.sort(arr);
        combinatio_withoutDP(res,0,target,ad,arr);
        return res;
    }
   public void combinatio_withoutDP(List<List<Integer>> res ,int index,int target , List<Integer> ad,int[] arr){
        if (target == 0 ){
            res.add(new ArrayList<>(ad));
            return;
        }else if(target<0){
            return;
        }
        for (int i = index; i < arr.length; i++) {
            if(i>index && arr[i-1] == arr[i])continue;

            ad.add(arr[i]);
            combinatio_withoutDP(res,i+1,target-arr[i],ad,arr);
            ad.remove(ad.size()-1);
        }
    }
}
