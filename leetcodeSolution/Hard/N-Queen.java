public class NQueen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<List<String>> ans = new ArrayList<>();
        NQueen nQueen = new NQueen();
        ans = nQueen.solveNQueens(n);
        for (int i = 0; i < ans.size(); i++) {
            System.out.println(ans.get(i));
        }
    }
    public List<List<String>> solveNQueens(int n) {
        String[][] chess = new String[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(chess[i],".");
        }
        List<List<String>> ans = new ArrayList<>();
        helper(n,0,chess,ans);
        return ans;
    }
    public void helper(int n,int i ,String[][] chess, List<List<String>> ans){
        if(n == 0){
            StringBuilder sb = new StringBuilder("");
            List<String> ad = new ArrayList<>();
            for (int j = 0; j < chess.length; j++) {
                for (int k = 0; k < chess.length; k++) {
                    sb.append(chess[j][k]);
                }
                ad.add(sb.toString());
                sb = new StringBuilder("");
            }
            ans.add(ad);
            return;
        }
        for (int j = 0; j < chess.length; j++) {
            if(chess[i][j] != "Q"){
                chess[i][j] = "Q";
                boolean up = true;
                boolean topleft = true;
                boolean topRight = true;
                int row = i,col = j;
                while (row>0){
                    if(chess[row-1][col].equals("Q")){
                        up = false;
                        break;
                    }
                    row--;
                }
                if(up == true) {
                    row = i;
                    col = j;
                    while (row > 0 && col > 0) {
                        if (chess[row - 1][col - 1].equals("Q")) {
                            topleft = false;
                            break;
                        }
                        row--;
                        col--;
                    }
                }
                if(up && topleft ) {
                    row = i;
                    col = j;
                    while (row > 0 && col < chess.length - 1) {
                        if (chess[row - 1][col + 1].equals("Q")) {
                            topRight = false;
                            break;
                        }
                        row--;
                        col++;
                    }
                }
                if(up && topleft && topRight){
                    helper(n-1,i+1,chess,ans);
                }
                chess[i][j] = ".";
            }
        }


    }
}
