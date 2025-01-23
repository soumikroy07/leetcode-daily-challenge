class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int m = isWater.length, n = isWater[0].length;
        boolean visited[][] = new boolean[m][n];
        int ans[][] = new int[m][n];
        int dirs[][] = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(isWater[i][j] == 1){
                    q.add(new int[]{i, j});
                    visited[i][j] = true;
                    ans[i][j] = 0;
                }
            }
        }


        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                int[] curr = q.poll();
                for(int dir[] : dirs){
                    int x = curr[0] + dir[0];
                    int y = curr[1] + dir[1];
                    if(isValid(ans, visited, x, y)){
                        ans[x][y] = ans[curr[0]][curr[1]] + 1;
                        visited[x][y] = true;
                        q.add(new int[]{x, y});
                    }
                }
            }
        }
        return ans;
    }

    boolean isValid(int ans[][], boolean visited[][], int i, int j){
        if(i < 0 || i >= ans.length || j < 0 || j >= ans[0].length || visited[i][j]){
            return false;
        }
        return true;
    }
}