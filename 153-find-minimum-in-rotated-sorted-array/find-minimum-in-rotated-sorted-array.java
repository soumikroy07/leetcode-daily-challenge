class Solution {
    public int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int low = 0, high = nums.length - 1;
        if (nums[low] < nums[high]) {
            return nums[low];
        }

        if (nums[high] < nums[high - 1]) {
            return nums[high];
        }
        while (low <= high) {
            // int mid = low + (high - low) / 2;

            int mid = low + (high - low) / 2;

            if (nums[mid] < nums[mid + 1] && nums[mid] < nums[mid - 1]) {
                return nums[mid];
            } else if (nums[mid] > nums[high]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }

        }

        return -1;
    }
}