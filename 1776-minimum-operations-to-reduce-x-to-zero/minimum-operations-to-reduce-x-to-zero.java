class Solution {
    public int minOperations(int[] nums, int x) {
        int sum = 0;

        for(int num: nums){
            sum += num;
        }

        if(sum == x){
            return nums.length;
        }

        int len = longestLengthOfSubArraySumEqualsK(nums, sum - x);

        return len == -1 ? len : nums.length - len; 
    }

    int longestLengthOfSubArraySumEqualsK(int nums[], int k){
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int ans = -1;
        map.put(0, -1);

        for(int i=0; i<nums.length; i++){
            sum += nums[i];
            if(map.containsKey(sum - k)){
                int j = map.get(sum - k);
                ans = Math.max(ans, i - j);
            }

            if(!map.containsKey(sum)){
                map.put(sum, i);
            }
        }

        return ans;
    }
}