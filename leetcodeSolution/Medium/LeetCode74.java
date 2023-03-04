class LeetCode74 {
    public boolean searchMatrix(int[][] arr, int target) {
          for(int i = 0;i<arr.length;i++){
            if(target>=arr[i][0]  && target<=arr[i][arr[i].length-1]){
                if(Arrays.binarySearch(arr[i],target)>=0){
                    return true;
                }
            }
        }
        return false;
    }
}
