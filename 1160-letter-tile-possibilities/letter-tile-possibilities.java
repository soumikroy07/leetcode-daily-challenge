class Solution {
    public int numTilePossibilities(String tiles) {
        int freq[] = new int[26];
        for (char c : tiles.toCharArray()) {
            freq[c - 'A']++;
        }
        return help(freq);
    }

    int help(int freq[]) {
        int ans = 0;
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                freq[i]--;
                ans += (1 + help(freq));
                freq[i]++;
            }
        }
        return ans;
    }
}