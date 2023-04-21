
public class Permutaion {
    public static void main(String[] args) {
       String s = "ABSG";
        List<String> ans = new ArrayList<>();
        boolean[] vist = new boolean[s.length()];

       permutation(0,s,ans,vist,"");
        System.out.println(ans);
    }

    private static void permutation(int i, String s, List<String> ans, boolean[] vist, String add) {
        if(add.length() == s.length()){
            if(!ans.contains(add)){
                ans.add(add);
                return;
            }
        }
        for (int j = 0; j < s.length(); j++) {
            if(vist[j] ==false){
                vist[j] = true;
                permutation(i+1,s,ans,vist,add+s.charAt(j));
                vist[j] = false;
            }
        }
    }


}
