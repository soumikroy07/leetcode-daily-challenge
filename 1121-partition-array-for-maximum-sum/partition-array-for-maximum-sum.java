// Tabulation

class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int dp[] = new int[n+1];
        
        for(int i=n-1; i>=0; i--){
            int len = 0, ans = 0, max = Integer.MIN_VALUE;
            for(int j=i; j<Math.min(n, i+k); j++){
                len++;
                max = Math.max(max, arr[j]);
                int sum = (len * max) + dp[j+1];
                ans = Math.max(ans, sum);
            }
            dp[i] = ans;
        }
        
        return dp[0];
        
    }
}


/*

memorization TC : O(n) * O(k)

class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int dp[] = new int[arr.length];
        return helper(arr, k, 0, dp);
    }
    
    int helper(int arr[], int k, int idx, int dp[]){
        if(idx >= arr.length) return 0;
        
        if(dp[idx] != 0) return dp[idx];
        
        int ans = 0, len = 0, max = Integer.MIN_VALUE;
        
        for(int j=idx; j<Math.min(arr.length, idx+k); j++){
            len++;
            max = Math.max(max, arr[j]);
            int sum = (max * len) + helper(arr, k, j+1, dp);
            ans = Math.max(sum, ans);
        }
        
        return dp[idx] = ans;
    }
}





resursive approch

class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        return helper(arr, k, 0);
    }
    
    int helper(int arr[], int k, int idx){
        if(idx >= arr.length) return 0;
        
        int ans = 0, len = 0, max = Integer.MIN_VALUE;
        
        for(int j=idx; j<Math.min(arr.length, idx+k); j++){
            len++;
            max = Math.max(max, arr[j]);
            int sum = (max * len) + helper(arr, k, j+1);
            ans = Math.max(sum, ans);
        }
        
        return ans;
    }
}

*/