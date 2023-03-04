class LeetCode77 {
     public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ad = new ArrayList<>();
        helper(1,k,n,ad,ans);
        return ans;
        }
    public void helper(int index , int k , int n , List<Integer> ad , List<List<Integer>> ans){
        if(ad.size() == k){
            ans.add(new ArrayList<>(ad));
            return;
        }
        if(index<=n){
            ad.add(index);
            helper(index+1,k,n,ad,ans);
            ad.remove(ad.size()-1);
            helper(index+1,k,n,ad,ans);
        }
    }

}
