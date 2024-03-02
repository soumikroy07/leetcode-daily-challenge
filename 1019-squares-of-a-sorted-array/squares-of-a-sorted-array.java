class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        
        int i=0, j=n-1;
        int pos = n-1;
        while(pos >= 0){
            if(Math.abs(nums[i]) > Math.abs(nums[j])){
                ans[pos] = nums[i] * nums[i];
                i++;
            }else{
                ans[pos] = nums[j] * nums[j];
                j--;
            }
            pos--;
        }
        return ans;
    }
}