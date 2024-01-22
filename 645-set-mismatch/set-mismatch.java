class Solution {
    public int[] findErrorNums(int[] nums) {
        int ans[] = new int[2];
        int n = nums.length, sum = 0;
        HashSet<Integer> set = new HashSet<>();
        int total = (n * (n+1)) / 2;
        for(int i=0; i<n; i++){
            if(set.contains(nums[i])){
                ans[0] = nums[i];
            }else{
                set.add(nums[i]);
                sum += nums[i];
            }
        }
        
        ans[1] = total-sum;
        
        return ans;
    }
}