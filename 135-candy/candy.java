class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int right[] = new int[n];
        int left[] = new int[n];
        Arrays.fill(right, 1);
        Arrays.fill(left, 1);

        for(int i=1; i<n; i++){
            right[i] = ratings[i-1] < ratings[i] ? right[i - 1] + 1 : 1;
        }

        for(int i=n-2; i>=0; i--){
            left[i] = ratings[i+1] < ratings[i] ? left[i+1]+1 : 1;
        }

        int sum = 0;

        for(int i=0; i<n; i++){
            sum += Math.max(left[i], right[i]);
        }

        return sum;
    }
}