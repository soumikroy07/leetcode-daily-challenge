/*
class Solution {
    int dp[][];
    public int longestCommonSubsequence(String text1, String text2) {
        dp = new int[text1.length()+1][text2.length()+1];
        return help(text1, text2, 0, 0);
    }

    int help(String text1, String text2, int i, int j){
        if(text1.length() == i || text2.length() == j){
            return 0;
        }
        if(dp[i][j] != 0){
            return dp[i][j];
        }
        int ans1 = 0, ans2 = 0;
        if(text1.charAt(i) == text2.charAt(j)){
            ans1 = 1 + help(text1, text2, i+1, j+1);
        }else{
            ans2 = Math.max(help(text1, text2, i+1, j), help(text1, text2, i, j+1));
        }

        return dp[i][j] = ans1+ans2;
    }
}

*/

class Solution {
    int dp[][];
    public int longestCommonSubsequence(String text1, String text2) {
        dp = new int[text1.length()+1][text2.length()+1];
        for(int i=0; i<=text1.length(); i++){
            for(int j=0; j<=text2.length(); j++){
                if(i == 0){
                    dp[i][j] = 0;
                }else if(j == 0){
                    dp[i][j] = 0;
                }else{
                    if(text1.charAt(i-1) == text2.charAt(j-1)){
                        dp[i][j] = 1+dp[i-1][j-1];
                    }else{
                        dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                    }
                }
            }
        }

        return dp[text1.length()][text2.length()];

        // return helper(text1, text2, 0, 0);
    }

    int helper(String s, String t, int i, int j){
        if(i == s.length() || j == t.length()){
            return 0;
        }

        if(s.charAt(i) == t.charAt(j)){
            return 1+helper(s, t, i+1, j+1);
        }else{
            return Math.max(helper(s, t, i+1, j), helper(s, t, i, j+1));
        }
    }
}