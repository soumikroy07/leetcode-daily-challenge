class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        int n = arr.length;
        int count[] = new int[2002];
        for(int i=0; i<n; i++){
            count[arr[i]+1000]++;
        }
        
        Arrays.sort(count);
        for(int i=0; i<2001; i++){
            if(count[i] != 0 && count[i] == count[i+1]){
                return false;
            }
        }
        return true;
    }
}