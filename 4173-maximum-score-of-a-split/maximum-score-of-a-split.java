class Solution {
    public long maximumScore(int[] nums) {
        int n = nums.length;
        long preSum[] = new long[n];
        int suffMin[] = new int[n];
        suffMin[n-1] = Integer.MAX_VALUE;
        long sum = 0;
        int min = Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            sum += (long)nums[i];
            // min = Math.min(min, nums[n - i - 1]);

            preSum[i] = sum;
            suffMin[n-i-1] = min; 
            min = Math.min(min, nums[n - i - 1]);
        }

        long ans = Long.MIN_VALUE;
        for(int i=0; i<n; i++){
            ans = Math.max(preSum[i] - suffMin[i], ans);
        }

        return ans;
    }
}