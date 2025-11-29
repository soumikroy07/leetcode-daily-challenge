class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length == 1){
            return true;
        }

        int boundary = nums[0], i = 0 ;

        while(i <= boundary){
            boundary = Math.max(i + nums[i], boundary);
            i++;
            if(boundary >= nums.length-1){
                return true;
            }
        }

        return false;
    }
}