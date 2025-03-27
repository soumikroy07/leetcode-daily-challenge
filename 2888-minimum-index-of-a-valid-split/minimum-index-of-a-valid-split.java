class Solution {
    public int minimumIndex(List<Integer> nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int mf = 0, me = 0;
        for(Integer num: nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
            if(map.get(num) > mf){
                mf = map.get(num);
                me = num;
            }
        }

        int count = 0;
        for(int i=0; i<nums.size(); i++){
            if(nums.get(i) == me){
                count += 1;
                int len = i+1;
                int rem = len - count;
                if(count - rem > 0){
                    int remLen = nums.size() - len;
                    int remCount = mf - count;
                    int remElement = remLen - remCount;
                    if(remCount - remElement > 0){
                        return i;
                    }
                }
            }
        }
        return -1;
    }
}