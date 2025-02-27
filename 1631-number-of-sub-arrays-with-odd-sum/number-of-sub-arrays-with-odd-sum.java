class Solution {
    int mod = (int)1e9 + 7;
    public int numOfSubarrays(int[] arr) {
        int sum = 0, even = 0, odd = 0, ans = 0;
        for(int a: arr){
            sum += a;
            if(sum % 2 == 0){
                ans += odd;
                ans = ans % mod;
                even += 1;
            }else{
                ans += even + 1;
                ans = ans % mod;
                odd += 1;
            }
        }
        return ans;
    }
}