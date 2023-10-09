class Solution {
    public int[] searchRange(int[] nums, int target) {
        // int ans[] = new int[2];
        if(nums.length == 0){
            return new int[]{-1, -1};
        }

        int low = 0, high = nums.length-1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(nums[mid] == target){
                int start = findStart(nums, low, mid, target);
                int end = findEnd(nums, mid, high, target);
                return new int[]{start, end};
            }
            else if(nums[mid] > target){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }

        return new int[]{-1, -1};
    }

    int findStart(int nums[], int low, int high, int key){
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(nums[mid] == key){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return low;
    }

    int findEnd(int nums[], int low, int high, int key){
        while(low <= high){
            int mid = low + (high - low)/2;
            if(nums[mid] == key){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return high;
    }
}