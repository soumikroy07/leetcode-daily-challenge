class Solution {
    public int findMaxFish(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean visited[][] = new boolean[m][n];
        int ans = 0; 
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] > 0 && !visited[i][j]){
                    int curr = dfs(grid, visited, i, j);
                    ans = Math.max(ans, curr);
                }
            }
        }

        return ans;
        /*
        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] > 0){
                    q.add(new int[]{i, j});
                }
            }
        }
        int dirs[][] = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        boolean visited[][] = new boolean[m][n];
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                int curr[] = q.poll();
                int currValue = grid[curr[0]][curr[1]];
                if(visited[curr[0]][curr[1]]){
                    continue;
                }else{
                    visited[curr[0]][curr[1]] = true;
                }
                for(int dir[]: dirs){
                    int x = curr[0] + dir[0];
                    int y = curr[1] + dir[1];
                    if(isValid(grid, visited, x, y)){
                        grid[x][y] = currValue + grid[x][y];
                        visited[x][y] = true;
                        q.add(new int[]{x, y});
                    }
                }
            }
        }
        int ans = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                ans = Math.max(ans, grid[i][j]);
            }
        }

        return ans;

        */


    }

    int dfs(int grid[][], boolean visited[][], int i, int j){
        Queue<int[]> q = new LinkedList<>();
        int dirs[][] = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        q.add(new int[]{i, j});
        visited[i][j] = true;
        int ans = 0;
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                int curr[] = q.poll();
                ans += grid[curr[0]][curr[1]];
                for(int dir[]: dirs){
                    int x = dir[0] + curr[0];
                    int y = dir[1] + curr[1];
                    if(isValid(grid, visited, x, y)){
                        q.add(new int[]{x, y});
                        visited[x][y] = true;
                    }
                }
            }
        }

        return ans;
    }

    boolean isValid(int grid[][], boolean visited[][], int i, int j){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length ||
                    grid[i][j] == 0 || visited[i][j]){
                        return false;
                    }

        return true;
    }
}