class Solution {
    int dp[];
    public int minCut(String s) {
        dp = new int[s.length()+1];
        Arrays.fill(dp, -1);
        return help(s, 0)-1;
    }

    int help(String s, int idx){
        if(idx == s.length()){
            return 0;
        }

        if(dp[idx] != -1){
            return dp[idx];
        }

        int ans = Integer.MAX_VALUE;

        for(int i=idx; i<s.length(); i++){
            if(isPalindrom(s, idx, i)){
                ans = Math.min(ans, 1 + help(s, i+1));
            }
        }
        return dp[idx] = ans;
    }

    boolean isPalindrom(String s, int i, int j){
        while(i < j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }

        return true;
    }
}

/*
class Solution {
    public int minCut(String s) {
        return help(s, 0) - 1; // -1 because we count partitions, not cuts
    }

    int help(String s, int idx){
        // Base case: reached end of string
        if(idx == s.length()){
            return 0;
        }

        int minCuts = Integer.MAX_VALUE;

        // Try all possible partitions starting from idx
        for(int i = idx; i < s.length(); i++){
            if(isPalindrome(s, idx, i)){
                // If s[idx...i] is palindrome, partition here
                // 1 + remaining partitions needed
                minCuts = Math.min(minCuts, 1 + help(s, i + 1));
            }
        }
        
        return minCuts;
    }

    boolean isPalindrome(String s, int i, int j){
        while(i < j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--; // This was your bug - should decrement j
        }
        return true;
    }
}

*/