class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int onesRow[] = new int[m];
        int zerosRow[] = new int[m];
        int onesCol[] = new int[n];
        int zerosCol[] = new int[n];
        
        
        for(int i=0; i<m; i++){
            int countZero = 0, countOne = 0;
            for(int j=0; j<n; j++){
                if(grid[i][j] == 0){
                    countZero++;
                }
                if(grid[i][j] == 1){
                    countOne++;
                }
            }
            onesRow[i] = countOne;
            zerosRow[i] = countZero;
        }
        
        for(int j=0; j<n; j++){
            int countZero = 0, countOne = 0;
            for(int i=0; i<m; i++){
                if(grid[i][j] == 0){
                    countZero++;
                }
                if(grid[i][j] == 1){
                    countOne++;
                }
            }
            onesCol[j] = countOne;
            zerosCol[j] = countZero;
        }
        
        int[][] diff = new int[m][n];
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                diff[i][j] = (onesRow[i] + onesCol[j] - zerosRow[i] - zerosCol[j]);
            }
        }
        
        return diff;
    }
}