class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        long r2l[] = new long[n];
        long l2r[] = new long[n];
        r2l[n-1] = nums[n-1];
        l2r[0] = nums[0];

        long max = (long)nums[n-1];
        for(int i=n-2; i>=0; i--){
            r2l[i] = max;
            max = Math.max(max, nums[i]);
        }

        max = (long)nums[0];

        for(int i=1; i<n; i++){
            l2r[i] = max;
            max = Math.max(max, nums[i]);
        }
        long ans = 0;
        for(int i=1; i<n-1; i++){
            ans = Math.max(ans, (l2r[i] - nums[i]) * r2l[i]);
        }
        return ans;
    }
}