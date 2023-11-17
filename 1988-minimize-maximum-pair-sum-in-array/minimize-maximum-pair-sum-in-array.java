class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int i=0, j=nums.length-1;

        int ans = 0;
        while(i < j){
            ans = Math.max(nums[i++]+nums[j--], ans);
        }
        return ans;
    }
}