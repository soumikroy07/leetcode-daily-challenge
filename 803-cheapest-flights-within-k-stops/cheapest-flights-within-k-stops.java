class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adj = new ArrayList<>();

        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] flight: flights){
            int s = flight[0], d = flight[1], price = flight[2];
            adj.get(s).add(new int[]{d, price});
        }

        int cost[] = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[src] = 0;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{src, 0, 0});

        while (!q.isEmpty()){
            int[] curr = q.poll();
            int curr_src = curr[0];
            int curr_cost = curr[1];
            int curr_stops = curr[2];

            if(curr_stops > k) continue;
            for (int[] nei: adj.get(curr_src)){
                int next_cost = nei[1];
                int next_dest = nei[0];
                if(cost[next_dest] > curr_cost + next_cost && curr_stops <= k){
                    cost[next_dest] = curr_cost + next_cost;
                    q.add(new int[]{next_dest, curr_cost + next_cost, curr_stops + 1});
                }
            }
        }

        return cost[dst] == Integer.MAX_VALUE ? -1 : cost[dst];
    }
}