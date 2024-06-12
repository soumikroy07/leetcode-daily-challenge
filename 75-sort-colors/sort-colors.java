class Solution {
    public void sortColors(int[] nums) {
        int zero =0, one = 0, two = nums.length-1;
        while(one <= two){
            if(nums[one] == 1){
                one++;
            }else if(nums[one] == 0){
                swap(nums, one, zero);
                one++;
                zero++;
            }else{
                swap(nums, one, two);
                two--;
            }
        }
    }

    void swap(int nums[], int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}