class Solution {
    public int minimumSum(int[] nums) {
        int n = nums.length;
        int l2r[] = new int[n];
        int r2l[] = new int[n];
        l2r[0] = -1;
        r2l[n-1] = -1;
        int ans = Integer.MAX_VALUE;

        int min = nums[0];
        for(int i=1; i<n; i++){
            if(min >= nums[i]){
                l2r[i] = -1;
                min = nums[i];
            }else{
                l2r[i] = min;
            }
        }
        min = nums[n-1];
        for(int i=n-2; i>=0; i--){
            if(min >= nums[i]){
                r2l[i] = -1;
                min = nums[i];
            }else{
                r2l[i] = min;
            }
        }

        for(int i=1; i<n-1; i++){
            if(l2r[i] != -1 && r2l[i] != -1){
                ans = Math.min(ans, nums[i] + l2r[i] + r2l[i]);
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}