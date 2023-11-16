class Solution {
    int dp[][];
    public boolean isMatch(String s, String p) {
        dp = new int[s.length()+1][p.length()+1];
        return help(s, p, 0, 0);
    }
    boolean help(String s, String p, int i, int j){
        if(i == s.length() && j == p.length()){
            return true;
        }

        if(i != s.length() && j == p.length()){
            return false;
        }

        if(i == s.length() && j < p.length()){
            for(int k=j; k <p.length(); k++){
                if(p.charAt(k) != '*'){
                    return false;
                }
            }
            return true;
        }

        if(dp[i][j] != 0){
            return dp[i][j] == 1 ? false : true;
        }

        boolean ans = false;
        if(s.charAt(i) == p.charAt(j)){
            ans = help(s, p, i+1, j+1);
        }else if(p.charAt(j) == '?'){
            ans = help(s, p, i+1, j+1);
        }else if(p.charAt(j) == '*'){
            ans = help(s, p, i+1, j) || help(s, p, i, j+1);
        }else{
            return false;
        }

        dp[i][j] = ans == false ? 1 : 2;

        return ans;
    }
}