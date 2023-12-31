class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int ans = -1;
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                ans = Math.max(ans, i - map.get(c) - 1);
                // map.put(c, i);
            }else{
                map.put(c, i);
            }
        }
        return ans;
    }
}