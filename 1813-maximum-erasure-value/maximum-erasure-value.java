class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        /*
        
        int right = 0, left = 0, sum = 0, ans = 0;
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        while(right < n){
            int val = num[right];
            if(!map.containsKey(val)){
                sum += val;
                ans = Math.max(sum, ans);
                
            }else{
                int idx = map.get(val);
                while(left <= idx){
                    sum -= val;
                    left++;
                }
            }
            map.put(val, right);
            right++;
        }
        return ans;

        */

        short[] nmap = new short[10001];
        int total = 0, best = 0;
        for (int left = 0, right = 0; right < nums.length; right++) {
            nmap[nums[right]]++;
            total += nums[right];
            while (nmap[nums[right]] > 1) {
                nmap[nums[left]]--;
                total -= nums[left++];
            }
            best = Math.max(best, total);
        }
        return best;
    }
}