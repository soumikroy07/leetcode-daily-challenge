class Solution {
    public int minCost(String s, int[] cost) {
        int n = s.length();
        int result = 0;
        for (int i=1; i<n; i++) {
            if (s.charAt(i) == s.charAt(i-1)) {
                result = result + Math.min(cost[i], cost[i-1]);
                cost[i] = Math.max(cost[i], cost[i-1]);
            }
        }
        return result;
    }
}

/*
class Solution {
    public int minCost(String s, int[] cost) {
        return help(s, cost, 1);
    }

    int help(String s, int cost[], int i){
        if(i == cost.length){
            return 0;
        }
        int ans1 = 0, ans2 = 0, ans = 0;
        if(s.charAt(i) == s.charAt(i-1)){
            ans += (help(s, cost, i+1) + Math.min(cost[i], cost[i-1]));
            cost[i] = Math.max(cost[i-1], cost[i]);
        }
        // ans += Math.min(ans1, ans2);
        return ans;
    }
}

*/