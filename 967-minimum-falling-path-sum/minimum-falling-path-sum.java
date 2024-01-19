class Solution {
    public int minFallingPathSum(int[][] matrix) {
        for(int i=1; i<matrix.length; i++){
            for(int j=0; j<matrix[i].length; j++){
                int sum = 0;
                if(j == 0){
                    int min = Math.min(matrix[i-1][j], matrix[i-1][j+1]);
                    sum = matrix[i][j] + min;
                }else if(j == matrix[i].length - 1){
                    int min = Math.min(matrix[i-1][j], matrix[i-1][j-1]);
                    sum = min + matrix[i][j];
                }else{
                    int min = Math.min(matrix[i-1][j-1], Math.min(matrix[i-1][j], matrix[i-1][j+1]));
                    sum = min + matrix[i][j];
                }
                
                matrix[i][j] = sum;
            }
        }
        
        int ans = Integer.MAX_VALUE;
        
        for(int i : matrix[matrix.length - 1]){
            ans = Math.min(ans, i);
        }
        
        return ans;
    }
}