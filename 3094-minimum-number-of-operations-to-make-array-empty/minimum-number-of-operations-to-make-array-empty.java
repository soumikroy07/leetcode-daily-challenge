class Solution {
    public int minOperations(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num: nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int ans = 0;
        for(Map.Entry<Integer, Integer> m: map.entrySet()){
            if(m.getValue() == 1){
                return -1;
            }else if(m.getValue() % 3 == 0){
                ans += (m.getValue() / 3);
            }else{
                ans += ((m.getValue() / 3) + 1);
            }
        }
        return ans;
    }
}