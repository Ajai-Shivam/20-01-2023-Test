class LeetCode47 {
    public List<List<Integer>> permuteUnique(int[] arr) {
       List<List<Integer>> result  = new ArrayList<>();
        backtrack(result,arr,0);
        return result;
    }
    public void backtrack(List<List<Integer>> result,int[] arr , int start){
        if(start == arr.length){
            List<Integer> ans = tolist(arr);
            if(!result.contains(ans)){
                result.add(ans);
            }

        }
        else{
            for (int i = start; i < arr.length; i++) {
                swap (i,start,arr);
                backtrack(result,arr,start+1);
                swap(i,start,arr);
            }
        }
    }
    public void swap(int i ,int j , int[] arr){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public List<Integer> tolist(int[] arr){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }
        return list;
    }
}
