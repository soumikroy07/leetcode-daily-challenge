class Solution {
    public int findSpecialInteger(int[] arr) {
        int count = 1;
        int len = arr.length;
        if(len == 1){
            return arr[0];
        }
        for(int i=0; i<len-1; i++){
            if(arr[i] == arr[i+1]){
                count += 1;
            }else{
                count = 1;
            }
            if(((double)len / 4.0) < (double)count){
                return arr[i];
            }
        }
        return -1;
    }
}