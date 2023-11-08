class Solution {
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        int x_diff = Math.abs(sx - fx), y_diff = Math.abs(sy - fy);
        
        if(x_diff == 0 && y_diff == 0 && t == 1){
            return false;
        }
        
        return Math.min(x_diff, y_diff) + Math.abs(x_diff - y_diff) <= t;
    }
}