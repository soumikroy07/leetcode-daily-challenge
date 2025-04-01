class Solution {
    long dp[];

    public long mostPoints(int[][] questions) {
        dp = new long[questions.length + 2];
        return help(questions, 0);
    }

    long help(int ques[][], int i){
        if(i >= ques.length){
            return 0;
        }
        // int ans = 0;
        if(dp[i] != 0){
            return dp[i];
        }
        long ans1 = ques[i][0] + help(ques, i + ques[i][1] + 1);
        long ans2 = help(ques, i+1);
        return dp[i] = Math.max(ans1, ans2);
    }
}