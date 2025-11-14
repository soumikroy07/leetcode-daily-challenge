class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int dirs[][] = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int m = mat.length, n = mat[0].length;
        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(mat[i][j] == 0){
                    q.add(new int[]{i, j});
                }else{
                    mat[i][j] = -1;
                }
            }
        }

        while(!q.isEmpty()){
            int curr[] = q.poll();
            for(int dir[]: dirs){
                int x = dir[0] + curr[0];
                int y = dir[1] + curr[1];

                if(x >= 0 && x < m && y >= 0 && y < n && mat[x][y] == -1){
                    q.add(new int[]{x, y});
                    mat[x][y] = 1 + mat[curr[0]][curr[1]];
                }
            }

        }

        return mat;
    }
}