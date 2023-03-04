class LeetCode78 {
    public List<List<Integer>> subsets(int[] nums) {
       List<List<Integer>> ans = new ArrayList<>();
            helper(0,nums,ans,new ArrayList<>());
        return ans;
    }
    public void helper(int index,int[] arr,List<List<Integer>> ad,ArrayList<Integer> ds){
        if(index==arr.length){
            ad.add(new ArrayList<>(ds));
            return;
        }
        ds.add(arr[index]);
        helper(index+1,arr,ad,ds);
        ds.remove(ds.size()-1);
        helper(index+1,arr,ad,ds);

}
}
