class Solution {
    boolean dp[][];
    boolean visited[][];
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum % 2 == 1) {
            return false;
        }

        sum = sum / 2;
        dp = new boolean[nums.length+1][sum+1];
        visited = new boolean[nums.length+1][sum+1];
        return help(nums, 0, sum);
    }

    boolean help(int nums[], int i, int sum) {
        if (sum == 0) {
            return true;
        }

        if (sum < 0 || i >= nums.length) {
            return false;
        }

        // if(visited[i][sum]){
        //     return dp[i][sum];
        // }
        if(dp[i][sum]){
            return false;
        }

        boolean ans1 = help(nums, i + 1, sum - nums[i]);
        boolean ans2 = help(nums, i + 1, sum);

        dp[i][sum] = true;

        // visited[i][sum] = true;
        // return dp[i][sum] = ans1 || ans2;
        return ans1 || ans2;
    }
}