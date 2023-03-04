class LeetCode63 {
    public int uniquePathsWithObstacles(int[][] mat) {
        for(int i =0;i<mat.length;i++){
            for(int j = 0;j<mat[0].length;j++){
                if(mat[i][j] == 1){
                    mat[i][j] = 0;
                }else if(i == 0 && j == 0){
                    mat[i][j] = 1;
                }
                else {
                    int up = 0,left = 0;
                    if(i>0) up = mat[i-1][j];
                    if(j>0) left = mat[i][j-1];
                    mat[i][j] = up+left;
                }   
            }
        }
        return mat[mat.length-1][mat[0].length-1];
    }

}
