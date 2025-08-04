class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0, right = 0, n = fruits.length, ans = 1;
        while(right < n){
            map.put(fruits[right], map.getOrDefault(fruits[right], 0)+1);
            if(map.size() > 2){
                map.put(fruits[left], map.get(fruits[left])-1);
                if(map.get(fruits[left]) == 0){
                    map.remove(fruits[left]);
                }
                left++;
            }
            int window = right - left + 1;
            ans = Math.max(window, ans);
            right++;
        }
        return ans;
    }
}