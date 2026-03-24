class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        Map<String, Integer> map = new HashMap<>();

        for(int mat[]: matrix){
            StringBuilder sb = new StringBuilder('T');
            for(int i=1; i<mat.length; i++){
                if(mat[0] == mat[i]){
                    sb.append('T');
                }else{
                    sb.append('F');
                }
            }
            map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
        }

        int ans = 0;
        for(Map.Entry<String, Integer> m: map.entrySet()){
            ans = Math.max(ans, m.getValue());
        }

        return ans;
    }
}