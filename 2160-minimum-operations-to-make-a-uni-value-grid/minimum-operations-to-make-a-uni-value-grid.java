class Solution {
    public int minOperations(int[][] grid, int x) {
        int m = grid.length, n = grid[0].length;
        int rem = -1;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                int currRem = grid[i][j] % x;
                if(rem == -1){
                    rem = currRem;
                }else{
                    if(currRem != rem){
                        return -1;
                    }
                }
            }
        }

        int arr[] = new int[m*n], k = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                arr[k++] = grid[i][j];
            }
        }

        Arrays.sort(arr);
        int len = arr.length;

        int mid = len / 2, steps = 0;
        for(int i=0; i<len; i++){
            steps += Math.abs(arr[i] - arr[mid]) / x;
        }

        return steps;
    }
}