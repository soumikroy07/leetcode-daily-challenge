class Solution {
    public long maxSum(List<Integer> nums, int m, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int i = 0;

       int max = -1;
       if(m == 1 && k == 1){
           for(int num : nums){
               max = Math.max(num, max);
           }
           return max;
       }

        long sum = 0;
        while(i < k){
            sum += (long)nums.get(i);
            map.put(nums.get(i), map.getOrDefault(nums.get(i), 0) + 1);
            i++;
        }

        long ans = 0;
        if(isValid(map.size(), m)){
            ans = sum;
        }

        int left = 0;
        for(int right = k; right < nums.size(); right++){
            sum += (long)nums.get(right);
            map.put(nums.get(right), map.getOrDefault(nums.get(right), 0)+1);
            sum -= (long)nums.get(left);
            map.put(nums.get(left), map.get(nums.get(left))-1);
            if(map.get(nums.get(left)) == 0){
                map.remove(nums.get(left));
            }
            if(isValid(map.size(), m)){
                ans = Math.max(ans, sum);
            }
            left++;
        }
        return ans;
    }
    
    private boolean isValid(int size, int m) {
        // return (size * (size - 1)) / 2 >= m;
//         if(map.size() >= m){
//             return true;
//         }

//         int val = 1;
//         for(Map.Entry<Integer, Integer> x: map.entrySet()){
//             val *= x.getValue();
//         }

//         return val - 1 >= m;

        return size >= m;
    }
}