class LeetCode73 {
    public void setZeroes(int[][] arr) {
         int m = arr.length,n = arr[0].length;
         int[][] mat = new int[m][n];
	  for(int i =0;i<m;i++){
		  for(int j=0;j<n;j++){
			  mat[i][j] = arr[i][j];
		  }
	  }
	  for(int i =0;i<arr.length;i++){
		   for(int j =0;j<arr[i].length;j++){
				if(mat[i][j]==0){
					for(int k=0;k<arr.length;k++){
  						arr[k][j] = 0;
					}
                    for(int k = 0;k<arr[0].length;k++){
                        arr[i][k] = 0;
                    }
				}
		}
	  }
    }
}
