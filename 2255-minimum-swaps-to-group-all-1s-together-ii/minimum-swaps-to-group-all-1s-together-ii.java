class Solution {
    public int minSwaps(int[] arr) {
        int window = 0;
        for(int num: arr){
            window += num == 1 ? 1 : 0;
        }
        
        int nums[] = new int[arr.length * 2];
        for(int i=0; i<arr.length; i++){
            nums[i] = arr[i];
            nums[i+arr.length] = arr[i];
        }
        int right = 0, left = 0;
        int count = 0, ans = Integer.MAX_VALUE;
        while(right < window){
            count += nums[right] == 0 ? 1 : 0;
            right ++;
        }

        ans = Math.min(count, ans);

        while(right < nums.length){
            count += nums[right] == 0 ? 1 : 0;
            count -= nums[left] == 0 ? 1 : 0;
            ans = Math.min(ans, count);
            right++;
            left += 1;
        }

        return ans;
    }
}