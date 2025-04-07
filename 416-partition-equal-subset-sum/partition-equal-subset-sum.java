class Solution {
    public boolean canPartition(int[] nums) {
        int total = 0;
        for(int i=0; i<nums.length; i++){
            total += nums[i];
        }
        if(total % 2 != 0) return false;
        
        int sum = total/2;
        boolean dp[][] = new boolean[nums.length+1][sum+1];
        
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                if(i==0 && j ==0){
                    dp[i][j] = true;
                }else if(i==0){
                    dp[i][j] = false;
                }else if(j == 0){
                    dp[i][j] = true;
                }else{
                    if(dp[i-1][j]){
                        dp[i][j] = true;
                    }else{
                        int val = nums[i-1];
                        if(j-val >= 0){
                            dp[i][j] = dp[i-1][j-val];
                        }
                    }
                }
            }
        }
        
        return dp[nums.length][sum];
        
        // return fun(nums, 0, sum);
    }
    
    boolean fun(int nums[], int i, int sum){
        if(sum == 0){
            return true;
        }
        boolean ans1=false, ans2=false;
        if(i < nums.length){
            ans1 = fun(nums, i+1, sum-nums[i]);
            ans2 = fun(nums, i+1, sum);
        }
        return ans1 || ans2;
    }
}