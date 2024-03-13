class Solution {
    public int pivotInteger(int n) {
        long right[] = new long[n+1];
        long left[] = new long[n+1];

        long sum = 0L;
        for(int i=1; i<=n; i++){
            sum += i;
            left[i] = sum;
        }
        sum = 0L;

        for(int i=n; i>0; i--){
            sum += i;
            right[i] = sum;
        }

        for(int i=1; i<=n; i++){
            if(left[i] == right[i]){
                return i;
            }
        }

        return -1;

    }
}