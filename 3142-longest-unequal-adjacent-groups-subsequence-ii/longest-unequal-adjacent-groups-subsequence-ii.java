class Solution {
    public boolean differByOneChar(String word1, String word2) {
        if (word1.length() != word2.length()) return false;
        int diffCount = 0;
        for (int i = 0; i < word1.length(); i++)
            if (word1.charAt(i) != word2.charAt(i))
                diffCount++;
        return diffCount == 1;
    }

    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        int n = groups.length;
        int[] dp = new int[n];
        int[] parent = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(parent, -1);
        int maxi = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (groups[i] != groups[j] &&
                    differByOneChar(words[i], words[j]) &&
                    dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    parent[i] = j;
                }
            }
            if (dp[i] > maxi) maxi = dp[i];
        }

        List<String> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (dp[i] == maxi) {
                while (i != -1) {
                    result.add(words[i]);
                    i = parent[i];
                }
                break;
            }
        }
        Collections.reverse(result);
        return result;
    }
}
/*
class Solution {
    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        List<String> ans = new ArrayList<>();
        // if(words.length == 1){
        //     ans.add(words[0]);
        //     return ans;
        // }
        int n = words.length;
        int lis[] = new int[n];
        Arrays.fill(lis, 1);
        int maxLength = 1;

        for (int i = 1; i<n; i++){
            for (int j=i-1; j >= 0; j--){
                if(groups[i] != groups[j] && isHammingDistance(words[i], words[j])){
                    lis[i] = Math.max(lis[i], lis[j] + 1);
                    maxLength = Math.max(lis[i], maxLength);
                }
            }
        }

        String prev = "";
        for (int i=n-1; i>=0; i--){
            if(lis[i] == maxLength && prev.length() == 0){
                prev = words[i];
                ans.add(prev);
                maxLength--;
            }

            if(lis[i] == maxLength && isHammingDistance(prev, words[i])){
                maxLength--;
                prev = words[i];
                ans.add(0, prev);
            }
        }
        return ans;
    }

    static boolean isHammingDistance(String s, String t){
        if(s.length() != t.length()){
            return false;
        }
        
        int count = 0;
        for (int i=0; i<s.length(); i++){
            if(s.charAt(i) != t.charAt(i)){
                count++;
            }
        }

        return  count <= 1;
    }
}

*/