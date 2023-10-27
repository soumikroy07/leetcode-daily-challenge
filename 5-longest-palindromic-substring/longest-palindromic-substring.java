class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean dp[][] = new boolean[n][n];
        int maxStart=0, maxEnd=0;
        String str="";
        for(int gap=0; gap<n; gap++){
            for(int i=0,j=gap; j<n; i++,j++){
                if(gap == 0){
                    dp[i][j] = true;
                }else if(gap == 1){
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                }else{
                    if(dp[i+1][j-1] && s.charAt(i) == s.charAt(j)){
                        dp[i][j] = true;
                    }
                }
                
                if(dp[i][j]){
                    maxStart = i;
                    maxEnd = j;
                    // str = s.substring(i,j+1);
                }
            }
        }
        // str = buildString(s,maxStart,maxEnd);
        str = s.substring(maxStart,maxEnd+1);
        return str;
    }
    
    String buildString(String str, int start, int end){
        String ans = "";
        while(start <= end){
            ans += str.charAt(start);
            start++;
        }
        return ans;
    }
}
/*
class Solution {
    public String longestPalindrome(String s) {
        String st = new StringBuilder(s).reverse().toString();
        String dp[][] = new String[s.length()+2][s.length()+2];
        for(int i=0; i<s.length(); i++){
            for(int j=0; j<s.length(); j++){
                dp[i][j] = "#";
            }
        }
        return help(s, st, 0, 0, dp);
    }

    String help(String s1, String s2, int i, int j, String dp[][]){
        if(i >= s1.length() || j >= s2.length()){
            return "";
        }
        if(!dp[i][j].equals("#")){
            return dp[i][j];
        }
        String ans = "";
        if(s1.charAt(i) == s2.charAt(j)){
            ans += (s1.charAt(i) + help(s1, s2, i+1, j+1, dp));
        }else{
            String ans1 = help(s1, s2, i+1, j, dp);
            String ans2 = help(s1, s2, i, j+1, dp);
            if(ans1.length() >= ans2.length()){
                ans += ans1;
            }else{
                ans += ans2;
            }
        }

        return dp[i][j] = ans;
    }
}

*/