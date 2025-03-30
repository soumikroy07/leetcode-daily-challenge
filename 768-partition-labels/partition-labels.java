class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> ans = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        int i=0;
        for(char c: s.toCharArray()){
            map.put(c, i++);
        }

        int prev = -1, max = 0;

        for(i=0; i<s.length(); i++){
            max = Math.max(max, map.get(s.charAt(i)));
            if(max == i){
                ans.add(max - prev);
                prev = max;
            }
        }
        return ans;
    }
}