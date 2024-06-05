class Solution {
    public List<String> commonChars(String[] words) {
        int hash[] = new int[26];
        
        for(int i=0; i<words[0].length(); i++){
            char c = words[0].charAt(i);
            hash[c - 'a']++;
        }
        
        for(int i=1; i<words.length; i++){
            int curr[] = new int[26];
            for(int j=0; j<words[i].length(); j++){
                char c = words[i].charAt(j);
                curr[c - 'a']++;
            }
            
            
            for(int j=0; j<26; j++){
                if(hash[j] > curr[j]){
                    hash[j] = curr[j];
                }
            }
        }
        
        List<String> ans = new ArrayList<>();
        
        for(int i=0; i<hash.length; i++){
            for(int j=0; j<hash[i]; j++){
                ans.add(Character.toString((char) ('a' + i)));
            }
        }
        
        return ans;
    }
}