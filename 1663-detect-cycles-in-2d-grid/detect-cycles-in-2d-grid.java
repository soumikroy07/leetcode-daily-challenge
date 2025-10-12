class Solution {
    int m, n;
    int dirs[][] = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    boolean visited[][];
    public boolean containsCycle(char[][] grid) { 
        m = grid.length;
        n = grid[0].length;
        visited = new boolean[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(!visited[i][j]){
                    if(hasCycle(grid, i, j, -1, -1)){
                        return true;
                    }
                }
            }
        }

        return false;
    }

    boolean hasCycle(char grid[][], int x, int y, int parentX, int parentY){
        if(visited[x][y]){
            return true;
        }

        visited[x][y] = true;
        for(int dir[]: dirs){
            int newX = x + dir[0];
            int newY = y + dir[1];
            if(newX == parentX && newY == parentY) continue;
            if(isValid(newX, newY) && grid[newX][newY] == grid[x][y]){
                if(hasCycle(grid, newX, newY, x, y)){
                    return true;
                }
            }
        }

        return false;
    }

    boolean isValid(int x, int y){
        if(x < 0 || x >= m || y < 0 || y >= n){
            return false;
        }
        return true;
    }
}