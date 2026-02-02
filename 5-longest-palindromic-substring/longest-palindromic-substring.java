class Solution {
    Boolean memo[][];
    int maxLen = 0;
    int idx = 0;
    public String longestPalindrome(String s) {
        int n = s.length();
        memo = new Boolean[n][n];

        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                if(isPalindrome(s, i, j)){
                    if(j - i + 1 > maxLen){
                        maxLen = j - i + 1;
                        idx = i;
                    }
                }
            }
        }

        return s.substring(idx, idx+maxLen);
    }

    boolean isPalindrome(String s, int i, int j){
        if(i > j){
            return true;
        }
        if(memo[i][j] != null){
            return memo[i][j];
        }
        boolean ans;
        if(s.charAt(i) == s.charAt(j)){
            ans = isPalindrome(s, i+1, j-1);
        }else{
            ans = false;
        }

        return memo[i][j] = ans;
    }
}