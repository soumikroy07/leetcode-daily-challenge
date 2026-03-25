class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int fast = 0, slow = 0;
        while(fast < n){
            if(nums[fast] != 0){
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }

        while(slow < n){
            nums[slow++] = 0;
        }
    }
}