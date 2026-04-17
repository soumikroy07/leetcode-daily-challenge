class Solution {
    public int minMirrorPairDistance(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = Integer.MAX_VALUE;
        for(int i=0; i<nums.length; i++){
            if(map.containsKey(nums[i])){
                int dist = i - map.get(nums[i]);
                ans = Math.min(ans, dist);
            }
            int revNum = reverse(nums[i]);
            map.put(revNum, i);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    int reverse(int num){
        int val = 0;
        while(num > 0){
            val = 10 * val + (num % 10);
            num = num / 10;
        }
        return val;
    }
}