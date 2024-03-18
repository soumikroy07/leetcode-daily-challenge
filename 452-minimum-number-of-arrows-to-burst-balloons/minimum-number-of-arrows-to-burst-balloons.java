class Solution {
    public int findMinArrowShots(int[][] points) {
        int n = points.length;
        //sorting based on ending index of ballon
        Arrays.sort(points,(a,b) -> Integer.compare(a[1],b[1]));

        //initial ballon point
        int r = points[0][1];
        int arrowsCount = 1;

        for(int i = 1; i < n; i++){
            if(points[i][0] > r){ //can't cover with same arrow
                arrowsCount++;
                r = points[i][1];
            }
        }
        return arrowsCount;     
    }
}