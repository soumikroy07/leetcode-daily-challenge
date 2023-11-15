class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        int prev = 0;
        for(int a: arr){
            prev = Math.min(a, prev+1);
        }
        return prev;
    }
}