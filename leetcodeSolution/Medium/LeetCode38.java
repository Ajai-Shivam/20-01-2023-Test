class LeetCode38 {
    public String countAndSay(int n) {
         String str =  "1";
        for(int i =1;i<n;i++){
            int j = 0;int k = 0;
            int count = 0;
            String add = "";
            while(j<str.length()){
                if(k<str.length() && str.charAt(j) == str.charAt(k)){
                    count++;
                    k++;
                }
                else{
                    add+=count;
                    add+=str.charAt(j);
                    j = k;
                    count = 0;
                }

            }
            str = add;
        }
    return str;
    }
}
