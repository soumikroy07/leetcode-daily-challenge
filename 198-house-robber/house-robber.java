class Solution {
    int dp[];
    public int rob(int[] nums) {
        dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return help(nums, 0);
    }

    int help(int nums[], int i){
        if(i >= nums.length){
            return 0;
        }
        if(dp[i] != -1){
            return dp[i];
        }
        int ans1 = help(nums, i+2) + nums[i];
        int ans2 = help(nums, i+1);
        return dp[i] = Math.max(ans1, ans2);
    }
}