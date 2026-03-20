class Solution {
    Boolean dp[][];
    int m, n;
    public boolean isMatch(String s, String p) {
        m = s.length();
        n = p.length();
        dp = new Boolean[m+1][n+1];
        return help(s, p, 0, 0);
    }

    private boolean help(String s, String p, int i, int j){
        if(i == m && j == n){
            return true;
        } 

        if(i < m && j == n){
            return false;
        }

        if(i == m && j < n){
            for(int k=j; k<n; k++){
                if(p.charAt(k) != '*'){
                    return false;
                }
            }
            return true;
        }

        if(dp[i][j] != null){
            return dp[i][j];
        }

        boolean ans = false;
        if(s.charAt(i) == p.charAt(j)){
            ans = help(s, p, i+1, j+1);
        }else if(p.charAt(j) == '*'){
            ans = help(s, p, i+1, j) || help(s, p, i, j+1);
        }else if(p.charAt(j) == '?'){
            ans = help(s, p, i+1, j+1);
        }else{
            ans = false;
        }

        return dp[i][j] = ans;
    }
}