class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int arr[][] = new int[mat.length][2];
        for(int i=0; i<mat.length; i++){
            int count = 0;
            for(int j=0; j<mat[0].length; j++){
                if(mat[i][j] == 1){
                    count++;
                }else{
                    break;
                }
            }
            arr[i][0] = count;
            arr[i][1] = i;
        }

        Arrays.sort(arr, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);

        int ans[] = new int[k];
        for(int i=0; i<k; i++){
            ans[i] = arr[i][1];
        }
        return ans;
    }
}