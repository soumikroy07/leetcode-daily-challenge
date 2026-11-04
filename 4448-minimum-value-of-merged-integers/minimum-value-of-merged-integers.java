class Solution {
    public int minMergedInteger(int[] nums) {
        int ans = Integer.MAX_VALUE, n = nums.length;

        for(int i=0; i<n; i+=2){
            String str = Integer.toString(nums[i]) + Integer.toString(nums[i+1]);
            ans = Math.min(ans, Integer.parseInt(str));
        }

        return ans;
    }
}