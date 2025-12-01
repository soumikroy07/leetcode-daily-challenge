class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int bucket[] = new int[n + 1];

        for (int citation : citations) {
            if (citation <= n) {
                bucket[citation] += 1;
            } else {
                bucket[n]++;
            }
        }

        int sum = 0;

        for (int i = n; i >= 0; i--) {
            sum += bucket[i];

            if (i <= sum) {
                return i;
            }
        }

        return -1;
    }
}