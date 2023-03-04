class LeetCode39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();

        helper(candidates,target,0,ans,new ArrayList<>());
        return ans;


    }
    public void helper(int[] candidates,int target,int index,List<List<Integer>> ans,List <Integer> ds){
        if(target<0){
            return;
        }
        if(target==0){
            ans.add(new ArrayList<>(ds));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            ds.add(candidates[i]);
            helper(candidates,target-candidates[i],i,ans,ds);
            ds.remove(ds.size()-1);
        }
    }
}
