class Solution {
    int max = 0;
    Integer dp[][];
    public int maximalSquare(char[][] matrix) {
        dp = new Integer[matrix.length][matrix[0].length];
        help(matrix, 0, 0);
        return max * max;
    }

    int help(char mat[][], int i, int j){
        if(i == mat.length || j == mat[0].length){
            return 0;
        }

        if(dp[i][j] != null){
            return dp[i][j];
        }

        int right = help(mat, i+1, j);
        int left = help(mat, i, j+1);
        int diagonal = help(mat, i+1, j+1);

        int current = 0;
        if(mat[i][j] == '1'){
            current = 1 + Math.min(right, Math.min(left, diagonal));
            max = Math.max(max, current);
        }
        return dp[i][j] = current;
    }
}