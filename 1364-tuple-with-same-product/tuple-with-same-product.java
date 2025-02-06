/*
class Solution {
    public int tupleSameProduct(int[] nums) {
        int ans = 0, n=nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<n-1; i++){
            for(int j=i+1; j<n; j++){
                map.put(nums[i] * nums[j], map.getOrDefault(nums[i] * nums[j], 0) + 1);
            }
        }

        for(Map.Entry<Integer, Integer> m : map.entrySet()){
            if(m.getValue() == 2){
                ans += 8;
            }else if(m.getValue() > 2){
                ans += 8 * m.getValue();
            }
        }

        return ans;
    }
}
*/


class Solution {
    public int tupleSameProduct(int[] nums) {
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                ans += 8 * map.getOrDefault(nums[i] * nums[j], 0);
                map.put(nums[i] * nums[j], map.getOrDefault(nums[i] * nums[j], 0) + 1);
            }
        }
        
        return ans;
    }
}