class LeetCode5 {
    public String longestPalindrome(String s) {
      int i = 0,j =s.length();
        int maxlen = 0;
        String ans = "";
        String org = s;
        while(i<j) {
            j = s.lastIndexOf(s.charAt(i));
            if(ispalindrome(s.substring(i,j+1))){
                if(s.substring(i,j+1).length()>maxlen){
                    maxlen = s.substring(i,j+1).length();
                    ans = s.substring(i,j+1);
                }
                i++;
                s = org;
                j = s.length();
            }else {
                s= s.substring(0,j);
                j = s.length();
            }
        }
        return ans;
    }
    public static boolean ispalindrome(String s){
        StringBuilder sb2 = new StringBuilder(s);
        sb2.reverse();
        if(s.equals(sb2.toString())){
            return true;
        }
        return false;
    }
}

