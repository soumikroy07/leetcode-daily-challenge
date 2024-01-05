class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = Integer.MIN_VALUE;

        for(int i=0; i<n; i++){
            int key = nums[i];
            int low = 0, high = i+1;
            while(low <= high){
                int mid = low + (high - low)/2;
                if(dp[mid] >= key && dp[mid - 1] < key){
                    dp[mid] = key;
                    break;
                }else if(dp[mid] < key){
                    low = mid + 1;
                }else{
                    high = mid - 1;
                }
            }
        }

        int ans = -1;
        for(int i=n; i>=0; i--){
            if(dp[i] != Integer.MAX_VALUE){
                ans = i;
                break;
            }
        }
        return ans;
    }
}