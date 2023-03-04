class LeetCode80 {
    public int removeDuplicates(int[] arr) {
    int count = 1;int pos =0;
    for(int i =1;i<arr.length;i++){
        if(arr[i]==arr[i-1]){
            count++;
            if(count<=2){
                pos++;
            }
        }else{
            arr[pos] = arr[i];
            pos++;
            count = 1;
            
        }
    }
    return pos;
    }
    
    }
