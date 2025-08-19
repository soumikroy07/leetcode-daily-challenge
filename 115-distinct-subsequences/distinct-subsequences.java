class Solution {
    int dp[][];
    public int numDistinct(String s, String t) {
        dp = new int[s.length() + 1][t.length() + 1];
        for(int d[]: dp){
            Arrays.fill(d, -1);
        }

        return help(s, t, s.length()-1, t.length()-1);
    }

    public int help(String s, String t, int i, int j){
        if(j < 0){
            return 1;
        }
        if(i < 0){
            return 0;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int ans1 = 0, ans2 = 0;

        if(s.charAt(i) == t.charAt(j)){
            ans1 = help(s, t, i-1, j-1) + help(s, t, i-1, j);
        }else{
            ans2 = help(s, t, i-1, j);
        }

        return dp[i][j]=Math.max(ans1, ans2);
    }
}