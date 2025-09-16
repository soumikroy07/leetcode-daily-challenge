class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length, res = 0, maxLength = 0;
        int length[] = new int[n];
        int count[] = new int[n];
        
        for(int i=0; i<n; i++){
            length[i] = count[i] = 1;
            for(int j=0; j<i; j++){
                if(nums[i] > nums[j]){
                    if(length[j]+1 == length[i]){
                        count[i] += count[j];
                    }
                    if(length[j]+1 > length[i]){
                        length[i] = length[j]+1;
                        count[i] = count[j];
                    }
                    
                }
            }
            
            if(maxLength == length[i]){
                res += count[i];
            }
            if(maxLength < length[i]){
                maxLength = length[i];
                res = count[i];
            }
        }
        
        return res;
    }
}