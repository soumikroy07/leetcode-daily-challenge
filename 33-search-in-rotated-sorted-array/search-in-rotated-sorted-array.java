class Solution {
    public int search(int[] nums, int target) {
        if(nums.length == 1 && nums[0] != target){
            return -1;
        }else if(nums.length == 1 && nums[0] == target){
            return 0;
        }
        int pivotIdx = searchPivot(nums);
        int ans = -1;
        if(pivotIdx == -1){
            return ans;
        }
        if(target < nums[0]){
            ans = searchIdx(nums, target, pivotIdx+1, nums.length-1);
        }else{
            ans = searchIdx(nums, target, 0, pivotIdx);
        }
        return ans;
    }

    private int searchIdx(int nums[], int target, int low, int high){
        int ans = -1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] > target){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return ans;
    }

    int searchPivot(int arr[]){
        int low = 0;
        int high = arr.length - 1;

        // If the array is not rotated
        if (arr[low] <= arr[high]) {
            return high;
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Check if mid+1 is the maximum element
            if (arr[mid + 1] < arr[mid]) 
                return mid;
            

            // Check if mid is the maximum element
            else if (arr[mid] < arr[mid - 1]) {
                return mid - 1;
            }

            // Decide whether to search in the left or right half
            else if (arr[high] > arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }
}