class Solution {
    public int[][] findFarmland(int[][] land) {
        List<List<Integer>> list = new ArrayList<>();
        int m = land.length, n = land[0].length;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(land[i][j] == 1){
                    int r = i, c = j;
                    for(r=i; r<m && land[r][j] == 1; r++){
                        for(c=j; c<n && land[r][c] == 1; c++){
                            land[r][c] = 0;
                        }
                    }
                    list.add(List.of(i, j, r-1, c-1));
                }
            }
        }
        int ans[][] = new int[list.size()][4];
        for(int i=0; i<ans.length; i++){
            for(int j=0; j<ans[0].length; j++){
                ans[i][j] = list.get(i).get(j);
            }
        }
        return ans;
    }
}