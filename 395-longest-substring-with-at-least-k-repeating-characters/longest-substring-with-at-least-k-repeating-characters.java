class Solution {
    public int longestSubstring(String s, int k) {
        return help(s.toCharArray(), 0, s.length(), k);
    }

    int help(char ch[], int start, int end, int k){
        if(end - start < k){
            return 0;
        }

        int count[] = new int[26];
        for(int i=start; i<end; i++){
            count[ch[i] - 'a']++;
        }

        for(int i=start; i<end; i++){
            if(count[ch[i] - 'a'] < k){
                int j = i+1;
                while(j < end && count[ch[j] - 'a'] < k){
                    j++;
                }

                return Math.max(help(ch, j, end, k), help(ch, start, i, k));
            }
        }

        return end-start;
    }
}