class Solution {
    public int heightChecker(int[] heights) {
        int n = heights.length;
        int expected[] = new int[n];
        for(int i=0; i<n; i++){
            expected[i] = heights[i];
        }
        Arrays.sort(expected);
        int count = 0;
        for(int i=0; i<n; i++){
            count += expected[i] != heights[i] ? 1 : 0;
        }
        return count;
    }
}