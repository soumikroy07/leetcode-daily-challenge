class Solution {
    boolean dp[][];
    public boolean canCross(int[] stones) {
        int n = stones.length;
        dp = new boolean[n][n];

        if(stones[1] != 1){
            return false;
        }
        return help(stones, 0, 1);
    }

    boolean help(int stones[], int lastIndex, int currIndex){
        if(currIndex == stones.length-1){
            return true;
        }

        if(dp[lastIndex][currIndex]) return false;

        int lastJump = stones[currIndex] - stones[lastIndex];
        int nextIndex = currIndex + 1;

        while(nextIndex < stones.length && stones[nextIndex] <= stones[currIndex] + lastJump + 1){
            int newJump = stones[nextIndex] - stones[currIndex];
            int jump = newJump - lastJump;
            if(jump >= -1 && jump <= 1){
                if(help(stones, currIndex, nextIndex)){
                    return true;
                }
            }
            nextIndex++;
        }

        dp[lastIndex][currIndex] = true;

        return false;

    }
}