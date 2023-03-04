class LeetCode17 {
        public List<String> letterCombinations(String digits) {
            String[] Keypad = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
            List<String> ans = new ArrayList<>(); 
            if(digits==null || digits.length()==0){
                return ans;
            }
            combination(digits,Keypad,"",0,ans);
            return ans;
        }
        public void combination(String digits,String[] Keypad,String curr,int index,List<String>ans){
            if(index==digits.length()){
                ans.add(curr);
                return;
            }
            String letter = Keypad[digits.charAt(index)-'0'];
            for(int i =0;i<letter.length();i++){
                combination(digits,Keypad,curr+letter.charAt(i),index+1,ans);
            }
        }
}
