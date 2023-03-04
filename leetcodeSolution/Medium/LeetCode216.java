class LeetCode216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] arr={1,2,3,4,5,6,7,8,9};
        List<Integer> l=new ArrayList<>();
        List<List<Integer>>res=new ArrayList<>();
        helper(0,l,res,k,n,arr);
        return res;
    }
    public void  helper(int ind,List<Integer> l,List<List<Integer>>res,int k,int n,int[] arr)
    {
        if(l.size() == k && n == 0)
        {
            res.add(new ArrayList<>(l));
            return;
        }
        if(l.size() >= k || n<0  || ind >8){
            return;
        }
        l.add(arr[ind]);
        helper(ind+1,l,res,k,n-arr[ind],arr);
        l.remove(l.size()-1);
        helper(ind+1,l,res,k,n,arr);
    }
}
