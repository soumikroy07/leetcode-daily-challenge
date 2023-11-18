class Solution {
    public int maxFrequency(int[] a, int k) {
        /*
        Arrays.sort(nums);
        int left = 0;
        int total = 0, ans = 0;
        
        for(int right = 0; right < nums.length; right++){
            total += nums[right];
            int window = right - left + 1;
            
            while(nums[right] * window > total+k){
                total -= nums[left];
                left++;
            }
            
            ans = Math.max(ans, window);
        }
        
        return ans;
        
        */
        
        
        int n = a.length;
        
        Arrays.sort(a);
        
        int ans = 0;
        int left = 0;
        
        long sum = 0;
        
        for(int right=0; right<n; right++) {
            sum += a[right];
            
            while(a[right]*1L*(right-left+1)-sum>k) {
                sum -= a[left];
                left++;
            }
            
            ans = Math.max(ans, right-left+1);
        }
        
        return ans;
    }
}