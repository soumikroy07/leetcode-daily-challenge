class Solution {
    public int[] constructDistancedSequence(int n) {
        int ans[] = new int[2*n - 1];
        boolean track[] = new boolean[n+1];
        generate(ans, track, 0, n);
        return ans;
    }

    boolean generate(int ans[], boolean track[], int index, int n){
        if(index == ans.length){
            return true;
        }
        if(ans[index] != 0){
            return generate(ans, track, index+1, n);
        }

        for(int i=n; i>=1; i--){
            int next = (i == 1) ? index : index+i;
            if(track[i] || (i > 1 && (next >= ans.length || ans[next] != 0))){
                continue;
            }

            ans[index] = i;
            ans[next] = i;
            track[i] = true;
            if(generate(ans, track, index+1, n)){
                return true;
            }
            ans[index] = 0;
            ans[next] = 0;
            track[i] = false;
            
        }
        return false;
    }
}