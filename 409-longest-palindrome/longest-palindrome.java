class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        
        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        int ans = 0, odd = 0;
        for(Map.Entry<Character, Integer> m : map.entrySet()){
            if(m.getValue() % 2 == 0){
                ans += m.getValue();
            }else{
                if(odd == 0){
                    odd++;
                    ans += m.getValue();
                }else{
                    ans += m.getValue() - 1;
                }
            }
        }
        
        
        return ans;
    }
}