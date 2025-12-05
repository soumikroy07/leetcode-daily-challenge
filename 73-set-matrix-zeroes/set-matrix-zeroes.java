class Solution {
    public void setZeroes(int[][] matrix) {
        boolean zero_row = false, zero_col = false;
        int m = matrix.length, n = matrix[0].length;
        for(int i=0; i<m; i++){
            if(matrix[i][0] == 0){
                zero_col = true;
            }
        }

        for(int j=0; j<n; j++){
            if(matrix[0][j] == 0){
                zero_row = true;
            }
        }

        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for(int i=1; i<m; i++){
            if(matrix[i][0] == 0){
                for(int j=0; j<n; j++){
                    matrix[i][j] = 0;
                }
            }
        }

        for(int j=1; j<n; j++){
            if(matrix[0][j] == 0){
                for(int i=0; i <m; i++){
                    matrix[i][j] = 0;
                }
            }
        }

        if(zero_col){
            for(int i=0; i<m; i++){
                matrix[i][0] = 0;
            }
        }

        if(zero_row){
            for(int j=0; j<n; j++){
                matrix[0][j] = 0;
            }
        }
    }
}