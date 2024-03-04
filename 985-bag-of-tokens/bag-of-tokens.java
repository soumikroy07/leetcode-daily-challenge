class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int i = 0, j = tokens.length - 1;
        
        int score = 0, ans = 0;
        
        while(i <= j){
            if(power >= tokens[i]){
                score++;
                ans = Math.max(score, ans);
                power -= tokens[i];
                i++;
            }else{
                if(score == 0){
                    return 0;
                }
                power += tokens[j];
                score--;
                j--;
                
            }
        }
        
        return ans;
    }
}