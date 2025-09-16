class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = Integer.MIN_VALUE;


        for(int i=0; i<n; i++){
            int num = nums[i];
            int low = 0, high = i+1;

            while(low <= high){
                int mid = low + (high - low) / 2;
                if(dp[mid] > num  && dp[mid-1] < num){
                    dp[mid] = num;
                    break;
                }else if(dp[mid] < num){
                    low = mid+1;
                }else{
                    high = mid-1;
                }
            }
        }

        int ans = -1;
        for(int i=0; i<n+1; i++){
            if(dp[i] != Integer.MAX_VALUE){
                ans = i;
            }else{
                break;
            }
        }

        return ans;
    }
}