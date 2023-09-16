class Solution {
    int dirs[][] = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        int diff[][] = new int[m][n];
        for(int d[]:diff){
            Arrays.fill(d, Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.add(new int[]{0, 0, 0});
        diff[0][0] = 0;

        while(!pq.isEmpty()){
            int curr[] = pq.poll();
            int x = curr[0], y = curr[1], dist = curr[2];

            for(int dir[]: dirs){
                int new_x = x+dir[0], new_y = y+dir[1];

                if(new_x >= 0 && new_x < m && new_y >= 0 && new_y < n){
                    int difference = Math.max(dist, Math.abs(heights[x][y] - heights[new_x][new_y]));
                    if(diff[new_x][new_y] > difference){
                        diff[new_x][new_y] = difference;
                        pq.add(new int[]{new_x, new_y, difference});
                    }
                }
            }
        }

        return diff[m-1][n-1];
    }
}