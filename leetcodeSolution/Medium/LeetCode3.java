class LeetCode3 {
    public int lengthOfLongestSubstring(String s) {
        StringBuilder sb = new StringBuilder(s);
        int i = 0,j=1;
        String check;
        int len = 0;
        while(i<=s.length()-1 && j<=s.length()){

            check = sb.substring(i,j);
            if(j==s.length()){
                i++;
            }
            if(j<s.length() && check.indexOf(sb.charAt(j))==-1){
                j++;
            }else if(j<s.length() && check.indexOf(sb.charAt(j))!=-1){
                i++;
                j=i+1;

            }
            len = Math.max(len,check.length());

            if(len>=s.length()-i){
                break;
            }
        }
        return len;
    }
}
