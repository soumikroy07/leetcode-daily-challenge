class Solution {
    public int minPenalty(int period, int[] lights, int[] arrival) {
        int max = Integer.MIN_VALUE;
        int ans = 0;

        for(int light: lights){
            max = Math.max(light, max);
        }

        for(int i=0; i<arrival.length; i++){
            arrival[i] = arrival[i] % period;
        }

        for(int a: arrival){
            if(a >= max){
                ans = Math.max(ans, period - a);
            }
        }

        return ans;
    }
}