class Solution {
    public int numSpecial(int[][] mat) {
        int m = mat.length, n = mat[0].length, count = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(mat[i][j] == 1){
                    if(checkRow(mat, i, n) && checkCol(mat, j, m)){
                        count += 1;
                    }
                }
            }
        }
        return count;
    }

    boolean checkRow(int mat[][], int row, int n){
        int count = 0;

        for(int i=0; i<n; i++){
            count += mat[row][i] == 1 ? 1 : 0;
        }

        return count == 1;
    }

    boolean checkCol(int mat[][], int col, int n){
        int count = 0;

        for(int i=0; i<n; i++){
            count += mat[i][col] == 1 ? 1 : 0;
        }

        return count == 1;
    }
}