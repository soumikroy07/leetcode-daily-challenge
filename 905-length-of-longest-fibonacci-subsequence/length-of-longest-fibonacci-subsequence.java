class Solution {
    /*
    public int lenLongestFibSubseq(int[] arr) {
        
        int n = arr.length;
        int dp[][] = new int[n][n];
        for(int d[]: dp){
            Arrays.fill(d, 2);
        }
        int maxLength = 0;

        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++){
            map.put(arr[i], i);
            for(int j=0; j<i; j++){
                int prev = arr[i] - arr[j];
                if(map.containsKey(prev) && map.get(prev) < j){
                    dp[i][j] = dp[map.get(prev)][j] + 1;
                    maxLength = Math.max(maxLength, dp[i][j]);
                }
            }
        }
        return maxLength == 2 ? 0 : maxLength;
    }
    */
        public int lenLongestFibSubseq(int[] A) {
        int n = A.length;
        int max = 0;
        int[][] dp = new int[n][n];
        for (int i = 2; i < n; i++) {
            int l = 0, r = i - 1;
	        while (l < r) {
                int sum = A[l] + A[r];
                if (sum > A[i]) {
                    r--;  
                } else if (sum < A[i]) {
                    l++;
                } else {
                    dp[r][i] = dp[l][r] + 1;
                    max = Math.max(max, dp[r][i]);
                    r--;
                    l++;
                }
            }
        }
        return max == 0 ? 0 : max + 2;
    }
}