class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum1 = 0, sum2 = 0;

        for(int g: gas){
            sum1 += g;
        }

        for(int c: cost){
            sum2 += c;
        }

        if(sum1 < sum2){
            return -1;
        }

        int ans = 0, sum = 0;
        for(int i=0; i<gas.length; i++){
            sum += (gas[i] - cost[i]);
            if(sum < 0){
                ans = i + 1;
                sum = 0;
                if(ans == gas.length){
                    ans = 0;
                }
            }
        }

        return ans;
    }
}