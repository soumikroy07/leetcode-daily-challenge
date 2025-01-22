class Solution {
    public long gridGame(int[][] grid) {
        long top = 0;
        for(int i=0; i<grid[0].length; i++){
            top += grid[0][i];
        }

        long currBottom = 0, currTop = top - grid[0][0];
        long robo2 = top-grid[0][0];
        for(int i=1; i<grid[0].length; i++){
            currBottom += grid[1][i-1];
            currTop -= grid[0][i];
            robo2 = Math.min(robo2, Math.max(currBottom, currTop));
        }

        return robo2;
    }
}