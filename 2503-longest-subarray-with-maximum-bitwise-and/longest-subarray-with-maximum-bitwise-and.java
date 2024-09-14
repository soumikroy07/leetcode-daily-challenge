class Solution {
    public int longestSubarray(int[] nums) {
        int count = 0, ans = 0, max = Integer.MIN_VALUE;
        
        for(int i=0; i<nums.length; i++){
            max = Math.max(max, nums[i]);
        }
        
        for(int i=0; i<nums.length; i++){
            if(nums[i] == max){
                count++;
            }else{
                count = 0;
            }
            
            ans = Math.max(count, ans);
        }
        
        return ans;
    }
}