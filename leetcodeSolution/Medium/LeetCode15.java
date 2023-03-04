class Solution {
    public List<List<Integer>> threeSum(int[] arr) {
       Set<List<Integer>> ans = new HashSet<>();
        int i = 0;
        int j = i+1, k = arr.length-1;
        Arrays.sort(arr);
        while (i< arr.length-2){
            List<Integer> ad = new ArrayList<>();

            if(i>0 && (arr[i]==arr[i-1])){
                i++;
                j = i+1;
                k = arr.length-1;
                continue;
            }
            if(arr[i]+arr[j]+arr[k]==0){
                ad.add(arr[i]);
                ad.add(arr[j]);
                ad.add(arr[k]);
                j++;
                k--;
                ans.add(ad);

            }
            else if(arr[i]+arr[j]+arr[k]>0){
                k--;
            }else{
                j++;
            }

            if(j>=k){
                i++;
                j = i+1;
                k = arr.length-1;
            }
        }
        List<List<Integer>> res = new ArrayList<>(ans);
        return res;
    }
}
