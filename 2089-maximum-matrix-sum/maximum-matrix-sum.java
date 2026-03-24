/*
class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int count = 0;
        int ans = 0;
        int min = Integer.MAX_VALUE;
        for (int mat[] : matrix) {
            for (int val : mat) {
                if (val < 0) {
                    count++;
                    min = Math.min(min, Math.abs(val));
                }
                ans += Math.abs(val);
            }
        }
        if(count % 2 == 0){
            return ans;
        }else{ 
            return ans - (2 * min);
        }

    }
}
*/

class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int n = matrix.length;

        int leastElement = 100001;
        long sum = 0L;
        int negativeCount = 0;

        for(int[] rows : matrix ){
            for(int value : rows){
                if(value < 0){
                    negativeCount++;
                    value = -value;
                }

                sum += value;
                if(value < leastElement){
                    leastElement = value;
                }
                
            }
        }

        return (negativeCount%2 == 0) ? sum : (sum - 2*leastElement);
    }
}