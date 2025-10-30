class Solution {
    int dp[][];
    public int minDistance(String word1, String word2) {
        dp = new int[word1.length()+1][word2.length()+1];
        for(int d[]: dp){
            Arrays.fill(d, -1);
        }
        return help(word1, word2, word1.length(), word2.length());
    }

    int help(String word1, String word2, int i, int j){
        if(i == 0){
            return j;
        }

        if(j == 0){
            return i;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int ans1 = 0, ans2 = 0;
        if(word1.charAt(i-1) == word2.charAt(j-1)){
            ans1= help(word1, word2, i-1, j-1);
        }else{
            ans2= 1+Math.min(help(word1, word2, i-1, j), Math.min(help(word1, word2, i-1, j-1), help(word1, word2, i, j-1)));
        }

        return dp[i][j] = ans1 + ans2;
    }
}