class Solution {
    int dp[][];
    public int minOperations(String s1, String s2, int x) {
        List<Integer> list = new ArrayList<>();

        for(int i=0; i<s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i)){
                list.add(i);
            }
        }

        if(list.size() % 2 != 0){
            return -1;
        }

        dp = new int[501][501];

        return help(list, 0, x, 0);
    }

    int help(List<Integer> list, int i, int x, int not_paired){
        if(i == list.size()){
            if(not_paired == 0){
                return 0;
            }else{
                return Integer.MAX_VALUE/2;
            }
        }
        if(dp[i][not_paired] != 0){
            return dp[i][not_paired];
        }
        int ans = Integer.MAX_VALUE;
        if(i < list.size()-1){
            ans = Math.min(list.get(i+1) - list.get(i) + help(list, i+2, x, not_paired), ans);
        }

        ans = Math.min(ans, x+help(list, i+1, x, not_paired+1));

        if(not_paired > 0){
            ans = Math.min(ans, help(list, i+1, x, not_paired-1));
        }
        return dp[i][not_paired] = ans;
    }
}