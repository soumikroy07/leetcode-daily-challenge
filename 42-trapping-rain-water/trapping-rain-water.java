class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int right[] = new int[n];
        int left[] = new int[n];

        int max = Integer.MIN_VALUE;
        for(int i=0; i < n; i++){
            max = Math.max(max, height[i]);
            left[i] = max;
        }

        max = Integer.MIN_VALUE;
        for(int i=n-1; i>=0; i--){
            max = Math.max(max, height[i]);
            right[i] = max;
        }

        int ans = 0;
        for(int i=0; i<n; i++){
            ans += (Math.min(left[i], right[i]) - height[i]);
        }
        return ans;
    }
}