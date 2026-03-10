class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = speed.length;
        int arr[][] = new int[n][2];
        for(int i=0; i<n; i++){
            arr[i][0] = position[i];
            arr[i][1] = speed[i];
        }

        Arrays.sort(arr, (a, b) -> a[0] != b[0] ? b[0] - a[0] : b[1] - a[1]);

        double time[] = new double[n];
        for(int i=0; i<n; i++){
            time[i] = (double) (target - arr[i][0]) / (double) arr[i][1];
        }

        double max = Double.MIN_VALUE;
        int count = 0;
        for(int i=0; i<n; i++){
            if(max < time[i]){
                max = time[i];
                count++;
            }
        }

        return count;
    }
}