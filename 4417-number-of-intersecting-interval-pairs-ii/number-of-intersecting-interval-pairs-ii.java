class Solution {
    public long countIntersectingIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int n = intervals.length;
        int i = 0;
        Long ans = 0L;
        while (i < n){
            int end = intervals[i][1];
            int idx = countIntersect(intervals, i+1, n-1, end);
            ans += idx > i ? idx - i : 0;
            i++;
        }
        return ans;
    }

    private static int countIntersect(int[][] intervals, int start, int end, int key) {
        int ans = -1;
        while (start <= end){
            int mid = start + (end - start) / 2;
            if(intervals[mid][0] <= key){
                ans = mid;
                start = mid+1;
            }else {
                end = mid - 1;
            }
        }
        return ans;
    }
}