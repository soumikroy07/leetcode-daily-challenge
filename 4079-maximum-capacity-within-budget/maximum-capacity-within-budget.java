class Solution {
    public int maxCapacity(int[] costs, int[] capacity, int budget) {
        int n = costs.length;
        int machine[][] = new int[n][2];
        for (int i = 0; i < n; i++) {
            machine[i][0] = costs[i];
            machine[i][1] = capacity[i];
        }

        Arrays.sort(machine, (a, b) -> a[0] - b[0]);

        int preMaxCapacity[] = new int[n];

        preMaxCapacity[0] = machine[0][0] < budget ? machine[0][1] : 0;
        int ans = machine[0][0] < budget ? machine[0][1] : -0;

        for (int i = 1; i < n; i++) {
            preMaxCapacity[i] = machine[i][0] < budget ? Math.max(preMaxCapacity[i - 1], machine[i][1]) : 0;
            ans = machine[i][0] < budget ? Math.max(ans, machine[i][1]) : ans;
        }

        for (int i = n - 1; i >= 0; i--) {
            int low = 0, high = i - 1;
            int currAns = 0;

            while (low <= high) {
                int mid = low + (high - low) / 2;

                if(machine[mid][0] + machine[i][0] < budget){
                    currAns = Math.max(currAns, machine[i][1] + preMaxCapacity[mid]);
                    low = mid + 1;
                }else{
                    high = mid-1;
                }
            }

            ans = Math.max(ans, currAns);
        }
        return ans;
    }
}