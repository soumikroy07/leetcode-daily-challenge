class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length == 1) return true;

        int boundary = nums[0];
        int i=0;
        while(i < boundary){
            i++;
            boundary = Math.max(nums[i]+i, boundary);
            if(boundary >= nums.length-1){
                return true;
            }
        }

        return false;
    }
}