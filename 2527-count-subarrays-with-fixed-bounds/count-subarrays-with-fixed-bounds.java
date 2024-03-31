class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int n = nums.length;
        long ans = 0L;
        
        int minI = -1, maxI = -1, start = 0;
        for(int i=0; i<n; i++){
            if(nums[i] < minK || nums[i] > maxK){
                minI = maxI = -1;
                start = i+1;
            }
            
            if(nums[i] == minK){
                minI = i;
            }
            
            if(nums[i] == maxK){
                maxI = i;
            }
            
            ans += Math.max(0L, Math.min(minI, maxI) - start + 1);
            
        }
        
        return ans;
    }
}