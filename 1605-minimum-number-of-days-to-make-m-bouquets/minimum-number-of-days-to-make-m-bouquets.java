class Solution {
    public int minDays(int[] bloom, int m, int k) {
        int total = m * k;
        int n = bloom.length;
        if(total > n){
            return -1;
        }

        int low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;

        for(int b: bloom){
            low = Math.min(b, low);
            high = Math.max(b, high);
        }

        int ans = -1;
        while(low <= high){
            int mid = low + (high - low) / 2;

            if(isValid(bloom, mid, m, k)){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return ans;
    }

    boolean isValid(int arr[], int mid, int m, int k){
        int count = 0;
        int noOfBloom = 0;

        for(int a: arr){
            if(a <= mid){
                count++;
            }else {
                count = 0;
            }

            if(count == k){
                noOfBloom += 1;
                count = 0;
            }
        }
        return m <= noOfBloom;
    }
}