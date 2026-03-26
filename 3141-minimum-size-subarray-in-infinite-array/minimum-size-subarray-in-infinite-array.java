class Solution {
    public int minSizeSubarray(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();
        int n = nums.length;
        int complete = (int)(target / sum),  partial = n;
        int start = 0;
        target = target % sum;

        for(int end=0; end< 2*n; end++){
            target -= nums[end % n];
            while(target < 0){
                target += nums[start % n];
                start++;
            }
            if(target == 0){
                partial = Math.min(partial, end - start + 1);
            }
        }
        return partial == n ? -1 : partial + (complete * n);
    }
}