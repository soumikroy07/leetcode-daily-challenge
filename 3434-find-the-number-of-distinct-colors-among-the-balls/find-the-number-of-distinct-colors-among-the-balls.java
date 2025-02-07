class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        Map<Integer, Integer> bc = new HashMap<>();
        Map<Integer, Integer> cf = new HashMap<>();
        int n = queries.length, i = 0;
        int ans[] = new int[n];

        for (int query[] : queries) {
            int ball = query[0], colour = query[1];
            if (bc.containsKey(ball)) {
                int c = bc.get(ball);
                cf.put(c, cf.get(c) - 1);
                if (cf.get(c) == 0) {
                    cf.remove(c);
                }
            }
            cf.put(colour, cf.getOrDefault(colour, 0) + 1);
            bc.put(ball, colour);
            ans[i++] = cf.size();

        }
        return ans;
    }
}