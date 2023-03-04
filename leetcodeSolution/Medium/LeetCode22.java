class LeetCode22 {
    public List<String> generateParenthesis(int n) {
         List<String> Result = new ArrayList<>();
        helper(n,Result,"",0,0);
        return Result;
    }
    private  void helper(int n, List<String> ans,String ad,int open,int close){
        if(open == n && close ==n){
            ans.add(ad);
            return;
        }

        if(open>close && close<n){
            helper(n,ans,ad+")",open,close+1);
        }

        if(open<n){
            helper(n, ans, ad + "(", open + 1, close);
        }
    }
}
