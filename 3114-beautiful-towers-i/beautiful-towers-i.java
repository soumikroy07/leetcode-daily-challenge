class Solution {
    public long maximumSumOfHeights(int[] heights) {
        int peak = 0, peak_idx = -1;
        for(int i=0; i<heights.length; i++){
            if(peak <= heights[i]){
                peak = heights[i];
                peak_idx = i;
            }
        }
        List<Integer> list = new ArrayList<>();
        int n = heights.length;
        for(int i=0; i<n; i++){
            if(heights[i] == peak){
                list.add(i);
            }
        }

        long ans = 0;
        for(int i=0; i<n; i++){
            int arr[] = Arrays.copyOf(heights, n);
            ans = Math.max(ans, findTotal(arr, heights[i], i));
        }

        return ans;

        
    }

    long findTotal(int heights[], int peak, int peak_idx){
        int left = peak;

        for(int i=peak_idx; i>=0; i--){
            if(left > heights[i]){
                left = heights[i];
            }else{
                heights[i] = left;
            }
        }

        int right = peak;

        for(int i=peak_idx; i<heights.length; i++){
            if(right > heights[i]){
                right = heights[i];
            }else{
                heights[i] = right;
            }
        }
        
        long total = 0;
        for(int h: heights){
            total += (long)h;
        }

        return total;
    }
}