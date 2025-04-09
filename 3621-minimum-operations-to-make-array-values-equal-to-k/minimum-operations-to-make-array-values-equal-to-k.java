class Solution {
    public int minOperations(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for(int num: nums){
            if(num < k){
                return -1;
            }
            set.add(num);
        }
        int ans = 0;
        for(Integer val: set){
            if(val == k){
                continue;
            }else{
                ans += 1;
            }
        }
        return ans;
    }
}