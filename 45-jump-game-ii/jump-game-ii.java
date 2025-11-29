class Solution {
    int dp[];
    public int jump(int[] nums) {
        dp = new int[nums.length];
        return help(nums, 0);
    }

    int help(int nums[], int i){
        if(i >= nums.length-1){
            return 0;
        }
        if(dp[i] != 0){
            return dp[i];
        }

        int jump = Integer.MAX_VALUE/2;

        for(int j=0; j<=nums[i]; j++){
            if(j == 0) continue;
            jump = Math.min(jump, 1 + help(nums, j+i));
        }

        return dp[i] = jump;
    }
}