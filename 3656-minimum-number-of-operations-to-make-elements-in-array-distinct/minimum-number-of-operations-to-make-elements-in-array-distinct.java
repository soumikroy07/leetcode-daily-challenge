class Solution {
    Map<Integer, Integer> map;
    public int minimumOperations(int[] nums) {
        map =  new HashMap<>();
        for(int num: nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int count = 0;
        int i=0;
        while(i < nums.length){
            if(isGood()){
                return count;
            }
            count += 1;
            // i = i+3;
            for(int k=i; k<Math.min(i+3,nums.length); k++){
                map.put(nums[k], map.get(nums[k]) - 1);
            }
            i = i+3;
        }

        return count;
    }

    boolean isGood(){
        for(Map.Entry<Integer, Integer> m: map.entrySet()){
            if(m.getValue() > 1){
                return false;
            }
        }
        return true;
    }
}