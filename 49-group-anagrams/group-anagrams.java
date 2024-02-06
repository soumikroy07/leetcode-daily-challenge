class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<HashMap<Character, Integer>, ArrayList<String>> map = new HashMap<>();
        
        for(String str : strs){
            HashMap<Character, Integer> frequency = new HashMap<>();
            
            for(char c : str.toCharArray()){
                frequency.put(c, frequency.getOrDefault(c, 0) + 1);
            }
            if(map.containsKey(frequency)){
                ArrayList<String> list = map.get(frequency);
                list.add(str);
                map.put(frequency, list);
            }else{
                ArrayList<String> list = new ArrayList<>();
                list.add(str);
                map.put(frequency, list);
            }
        }
        
        List<List<String>> ans = new ArrayList<>();
        
        for(Map.Entry<HashMap<Character, Integer>, ArrayList<String>> m : map.entrySet()){
            ans.add(m.getValue());
        }
        
        return ans;
    }
}