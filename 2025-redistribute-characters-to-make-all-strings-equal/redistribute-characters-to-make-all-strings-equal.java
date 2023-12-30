class Solution {
    public boolean makeEqual(String[] words) {
        Map<Character, Integer> map = new HashMap<>();

        for(String word: words){
            for(char c: word.toCharArray()){
                map.put(c, map.getOrDefault(c, 0)+1);
            }
        }

        for(Map.Entry<Character, Integer> m : map.entrySet()){
            if(m.getValue() % words.length != 0){
                return false;
            }
        }

        return true;
    }
}