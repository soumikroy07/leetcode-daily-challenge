class Solution {
    public int uniquePaths(int m, int n) {
        int path[][] = new int[m][n];
        for(int i=0; i<m; i++){
            path[i][n-1] = 1;
        }

        for(int i=0; i<n; i++){
            path[m-1][i] = 1;
        }

        for(int i=m-2; i>=0; i--){
            for(int j=n-2; j>=0; j--){
                path[i][j] = path[i][j+1] + path[i+1][j];
            }
        }

        return path[0][0];
    }
}