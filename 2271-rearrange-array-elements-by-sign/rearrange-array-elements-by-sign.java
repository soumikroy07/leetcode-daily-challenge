class Solution {
    public int[] rearrangeArray(int[] nums) {
        
        int ans[] = new int[nums.length];
        int pos = 0, neg = 0, k = 0;

        while((pos < nums.length || neg < nums.length) && k < nums.length){
            if(k == 0 || k % 2 == 0){
                while(pos < nums.length && nums[pos] < 0){
                    pos++;
                }
                ans[k++] = nums[pos++];
            }

            else{
                while(neg < nums.length && nums[neg] > 0){
                    neg++;
                }
                ans[k++] = nums[neg++];
            }
        }

        return ans;
    }
}