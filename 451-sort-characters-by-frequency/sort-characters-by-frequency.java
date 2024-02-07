class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        ArrayList<Pair> list = new ArrayList<>();
        for(Map.Entry<Character, Integer> m : map.entrySet()){
            list.add(new Pair(m.getKey(), m.getValue()));
        }
        
        Collections.sort(list);
        
        StringBuilder sb = new StringBuilder();
        for(Pair letters : list){
            int count = letters.freq;
            char letter = letters.c;
            
            while(count-- > 0){
                sb.append(letter);
            }
        }
        
        return sb.reverse().toString();
    }
}

class Pair implements Comparable<Pair>{
    char c;
    int freq;
    
    Pair(char ch, int f){
        c = ch;
        freq = f;
    }
    
    public int compareTo(Pair o){
        return this.freq - o.freq;
    }
}