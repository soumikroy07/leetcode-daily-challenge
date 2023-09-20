class Solution {
    public int minOperations(int[] nums, int x) {
        int res = -1;
        int sum = 0;
        for(int n : nums){
            sum += n;
        }
        if(sum == x){
            return nums.length;
        }
        int s = 0;
        int sidx = 0;

        for(int i = 0; i < nums.length; i++){
            s += nums[i];
            while(sidx < i && sum - s < x){
                s -= nums[sidx++];
            }
            if(sum - s == x){
                res = Math.max(res, i - sidx + 1);
            }
        }
        if(res == -1){
            return res;
        }
        return nums.length - res;
    }
}