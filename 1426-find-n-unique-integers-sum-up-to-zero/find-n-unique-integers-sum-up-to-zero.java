class Solution {
    public int[] sumZero(int n) {
//         if(n == 0){
//             return new int[0];
//         }
        
//         if(n == 1){
//             return new int[]{0};
//         }
        int ans[] = new int[n];
        for(int i=0; i<n; i++){
            ans[i] = 2*i - n + 1;
        }
        
        return ans;
    }
}