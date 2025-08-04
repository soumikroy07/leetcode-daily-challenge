class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int ans = 0, product = 1, right = 0, left = 0;

        int n = nums.length;
        if(k <= 1){
            return 0;
        }

        while(right < n){
            product *= nums[right];
            while(left < n && product >= k){
                product /= nums[left];
                left += 1;
            }

            ans += (right - left + 1);
            right += 1;
        }

        return ans;
    }
}