class Solution {
    Map<String, Integer> map;
    public int findTargetSumWays(int[] nums, int target) {
        // dp = new int[nums.length+1][target+1];
        map = new HashMap<>();
        return help(nums, 0, target);
    }

    int help(int nums[], int i, int target) {
        if (i == nums.length) {
            if (target == 0) {
                return 1;
            }
            return 0;
        }
        // if(target < 0){
        //     return 0;
        // }
        String s = i + " " + target;
        if(map.containsKey(s)){
            return map.get(s);
        }

        // if(dp[i][target] != 0){
        //     return dp[i][target];
        // }
        int ans = 0;

        ans += help(nums, i + 1, target - nums[i]) + help(nums, i + 1, target + nums[i]);

        map.put(s, ans);

        return ans;
    }
}