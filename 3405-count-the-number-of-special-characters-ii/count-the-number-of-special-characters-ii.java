class Solution {
    public int numberOfSpecialChars(String word) {
        int small[] = new int[26];
        int caps[] = new int[26];
        Set<Character> set = new HashSet<>();
        int count = 0;

        for(char c: word.toCharArray()){
            if(c <= 'z' && c >= 'a'){
                small[c - 'a']++;
                set.add(c);
            }else{
                caps[c - 'A']++;
            }
        }

        for(char c: word.toCharArray()){
            if(c <= 'z' && c >= 'a'){
                small[c - 'a']--;
            }else{
                char ch = (char)(c - 'A' + 'a');
                if(set.contains(ch) && small[ch - 'a'] == 0){
                    count++;
                }
                small[ch - 'a'] = Integer.MAX_VALUE;
                
            }
        }

        return count;
    }
}