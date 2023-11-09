class Solution {
    int mod = (int)1e9+7;
    public int countHomogenous(String s) {
        /*
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, n = s.length(), ans = 0;

        for(int right = 0; right<n; right++){
            char c = s.charAt(right);
            map.put(c, map.getOrDefault(c, 0)+1);
            if(map.size() > 1){
                int count = map.get(s.charAt(left));
                ans += (count * (count+1)) / 2;
                ans = ans % mod;
                map.remove(s.charAt(left));
                left = right;
            }
        }
        int val = map.get(s.charAt(left));
        ans += (val * (val+1)) / 2;
        ans = ans % mod;
        return ans;

        */

        int cnt = 0, res = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (i > 0 && s.charAt(i - 1) == s.charAt(i))
                ++cnt;
            else
                cnt = 1;
            res = (res + cnt) % 1000000007;
        }
        return res;
    }
}