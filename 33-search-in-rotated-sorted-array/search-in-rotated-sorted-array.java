class Solution {
    public int search(int[] arr, int target) {
        
        int low = 0, high = arr.length - 1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(target == arr[mid]){
                return mid;
            }else if(arr[low] <= arr[mid]){
                if(arr[mid] >= target && arr[low] <= target){
                    high = mid-1;
                }else{
                    low = mid+1;
                }
            }else{
                if(arr[mid] <= target && arr[high] >= target){
                    low = mid+1;
                }else{
                    high = mid-1;
                }
            }
        }

        return -1;
    }
}