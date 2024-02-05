class Solution {
    public int firstUniqChar(String s) {
        int freq[] = new int[26];
        for(char c: s.toCharArray()){
            freq[c - 'a']++;
        }

        int idx = 0;
        for(char c: s.toCharArray()){
            if(freq[c - 'a'] == 1){
                return idx;
            }
            idx++;
        }
        return -1;
    }
}