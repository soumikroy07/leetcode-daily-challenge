class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> small = new HashMap<>();
        String ans = "";
        for(char c : t.toCharArray()){
            small.put(c, small.getOrDefault(c, 0)+1);
        }
        
        int match = 0, totalMatch = t.length();
        Map<Character, Integer> large = new HashMap<>();
        int i=-1, j=-1;
        while(true){
            boolean f1 = false, f2 = false;
            while(i<s.length()-1 && match < totalMatch){
                i++;
                char c = s.charAt(i);
                large.put(c, large.getOrDefault(c, 0)+1);
                
                if(large.getOrDefault(c, 0) <= small.getOrDefault(c, 0)){
                    match++;
                }
                
                f1 = true;
            }
            
            while(i > j && match == totalMatch){
                j++;
                String str = s.substring(j, i+1);
                if(ans.length() == 0 || ans.length() > str.length()){
                    ans = str;
                }
                
                char c = s.charAt(j);
                if(large.get(c) == 0){
                    large.remove(c);
                }
                else{
                    large.put(c, large.get(c) - 1);
                }
                
                if(large.getOrDefault(c, 0) < small.getOrDefault(c, 0)){
                    match--;
                }
                f2 = true;
            }
            
            if(f1 == false && f2 == false){
                break;
            }
        }
        
        return ans;
    }
}