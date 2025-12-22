class Solution {
    public long minMoves(int[] balance) {
        long sum = 0; int idx = -1;
        int n = balance.length;
        for(int i=0; i<n; i++){
            sum += balance[i];
            if(balance[i] < 0) idx = i;
        }
        if(sum < 0) return -1;
        if(idx == -1) return 0;
        long val = balance[idx];
        int left = (idx-1+n) % n; int right = (idx+1) % n;
        int i=1; long ans = 0; 
        while(val < 0){
            if(balance[left] > 0){
                long take = Math.min(balance[left], -val);
                val += take;
                ans += take * i;
            }

            if(val < 0 && balance[right] > 0){
                long take2 = Math.min(balance[right], -val);
                val += take2;
                ans += take2 * i;
            }
            left = (left - 1 + n) % n;
            right = (right + 1) % n;
            i++;
        }
        return ans;
    }
}
/*
class Solution {
    public long minMoves(int[] balance) {
        int n = balance.length;
        int sum = 0;
        for (int bal : balance) {
            sum += bal;
        }

        if (sum < 0) {
            return -1;
        }

        int idx = -1, target = 0;

        for (int i = 0; i < n; i++) {
            if (balance[i] < 0) {
                target = balance[i] * -1;
                idx = i;
            }
        }

        if(idx == -1){
            return 0;
        }

        int dist = 1;
        long ans = 0L;
        while (target > 0) {
            int next = (idx + dist) % n;
            int prev = (idx - dist + n) % n;

            if (target > balance[next]) {
                ans += (long)(balance[next] * dist);
                target -= balance[next];

            } else {
                ans += (long)target * dist;
                target = 0;
            }

            if (target > 0) {
                if (target > balance[prev]) {
                    ans += (long)(balance[prev] * dist);
                    target -= balance[prev];
                } else {
                    ans += (long)target * dist;
                    target = 0;
                }
            }
            dist += 1;
        }

        return ans;
    }
}
*/