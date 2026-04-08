class Solution {
    public int[] findIndices(int[] nums, int idxDiff, int vDiff) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        int max_idx = -1, min_idx = -1;

        if(nums.length < idxDiff){
            return new int[]{-1, -1};
        }

        for(int i=0; i<nums.length-idxDiff; i++){
            if(nums[i] < min){
                min_idx = i;
                min = nums[i];
            }

            if(nums[i] > max){
                max_idx = i;
                max = nums[i];
            }

            if(Math.abs(nums[i+idxDiff] - min) >= vDiff){
                return new int[]{min_idx, i+idxDiff};
            }

            if(Math.abs(max - nums[i+idxDiff]) >= vDiff){
                return new int[]{max_idx, i+idxDiff};
            }
        }
        return new int[]{-1, -1};
    }
}