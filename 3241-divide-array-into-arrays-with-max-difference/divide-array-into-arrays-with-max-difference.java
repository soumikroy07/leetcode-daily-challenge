class Solution {
    public int[][] divideArray(int[] nums, int k) {
        int ans[][] = new int[nums.length/3][3];
        int i = 0, s=0;
        int n = nums.length;
        Arrays.sort(nums);
        while(i+2 < n){
            int start  = i, end = i+2;
            if(nums[end] - nums[start] > k){
                return new int[0][0];
            }
            for(int j=start, x=0; j<=end && x<3; j++,x++){
                ans[s][x] = nums[j];
            }
            s++;
            i = end+1;
        }
        return ans;
    }
}