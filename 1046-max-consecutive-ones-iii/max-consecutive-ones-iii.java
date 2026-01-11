class Solution {
    public int longestOnes(int[] nums, int k) {
        int zero = 0, ans = 0;
        int n = nums.length, left = 0;
        for(int right=0; right<n; right++){
            zero += nums[right] == 0 ? 1 : 0;

            while(zero > k){
                zero -= nums[left] == 0 ? 1 : 0;
                left++;
            }

            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }
}