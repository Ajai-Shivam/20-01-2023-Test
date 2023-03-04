class LeetCode59 {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int row_begin = 0,row_end = ans.length-1;
        int col_begin = 0,col_end = ans[0].length-1;
        int store = 1;
        while(row_begin<=row_end && col_begin<=col_end){
            for(int i =col_begin;i<=col_end;i++){
                ans[row_begin][i] = store;
                store++;
            }
            row_begin++;
            for(int i =row_begin;i<=row_end;i++){
                ans[i][col_end] = store;
                store++;
            }
            col_end--;
            if(row_begin<=row_end){
                for(int i =col_end;i>=col_begin;i--){
                    ans[row_end][i] = store;
                    store++;
                }
                row_end--;
            }
            if(col_begin<=col_end){
                for(int i =row_end;i>=row_begin;i--){
                    ans[i][col_begin] = store;
                    store++;
                }
                col_begin++;
            }
        }
        return ans;
    }
}
