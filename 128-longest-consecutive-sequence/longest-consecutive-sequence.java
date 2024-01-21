class Solution {
    public int longestConsecutive(int[] arr) {
        if(arr.length == 0){
            return 0;
        }
        Arrays.sort(arr);
        int i = 0, n = arr.length, ans = 1;
        while(i < n){
            int j = i, dup = 0;
            while(j < n-1 && arr[j+1] - arr[j] <= 1){
                if(arr[j+1] - arr[j] == 0){
                    dup++;
                }
                j++;
            }
            ans = Math.max(ans, j - i + 1 - dup);
            i = j+1;
            dup = 0;
        }

        return ans;
    }
}

// 100,4,200,1,3,2

// 1,2,3,4,100,200