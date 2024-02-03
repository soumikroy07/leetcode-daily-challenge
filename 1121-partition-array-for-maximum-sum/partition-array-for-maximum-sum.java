class Solution {
    int dp[];
    public int maxSumAfterPartitioning(int[] arr, int k) {
        dp = new int[arr.length+1];
        return help(arr, k, 0);
    }

    int help(int arr[], int k, int idx){
        if(idx >= arr.length){
            return 0;
        }
        if(dp[idx] != 0){
            return dp[idx];
        }
        int ans = 0, max = 0, len = 0;;
        for(int i=idx; i<Math.min(idx+k, arr.length); i++){
            len++;
            max = Math.max(max, arr[i]);
            int sum = (max * len) + help(arr, k, i+1);
            ans = Math.max(sum, ans);
        }

        return dp[idx] = ans;
    }
}