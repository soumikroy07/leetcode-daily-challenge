class Solution {
    public int[] rearrangeArray(int[] nums) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int n = nums.length;
        for(int num: nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int ans[] = new int[n];
        int i = 0;
        Map<Integer, Integer> map1 = new HashMap<>();

        while(map.size() > 0){
            for(Map.Entry<Integer, Integer> m: map.entrySet()){
                ans[i++] = m.getKey();
                int value = m.getValue()-1;
                map1.put(m.getKey(), value);
            }
            map.clear();

            for(Map.Entry<Integer, Integer> m: map1.entrySet()){
                if(m.getValue() == 0){
                    continue;
                }
                map.put(m.getKey(), m.getValue());
            }
            map1.clear();
        }

        return ans;
    }
}