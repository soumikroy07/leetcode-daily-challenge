class Solution {
    public int characterReplacement(String s, int k) {
        int ans = 0;
        int left = 0, maxFreq = 0;
        int freq[] = new int[26];
        for(int right = 0; right < s.length(); right++){
            freq[s.charAt(right) - 'A']++;
            maxFreq = Math.max(maxFreq, freq[s.charAt(right) - 'A']);
            while(right - left + 1 - maxFreq > k){
                freq[s.charAt(left) - 'A']--;
                left++;
            }
            ans = Math.max(ans, right - left + 1);
            // right++;
        }
        
        return ans;
    }
    
}