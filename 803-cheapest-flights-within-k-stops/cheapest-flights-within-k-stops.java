class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<Pair>());
        }
        
        for(int i=0; i<flights.length; i++){
            adj.get(flights[i][0]).add(new Pair(flights[i][1], flights[i][2]));
        }
        
        int distance[] = new int[n];
        for(int i=0; i<n; i++){
            distance[i] = Integer.MAX_VALUE;
        }
        distance[src] = 0;
        
        Queue<Triple> q = new LinkedList<>();
        
        q.add(new Triple(0, src, 0));
        
        while(!q.isEmpty()){
            Triple curr = q.poll();
            int stops = curr.stops;
            int node = curr.node;
            int cost = curr.cost;
            
            if(stops > k) continue;
            for(Pair neighbour : adj.get(node)){
                int destination = neighbour.des;
                int currCost = neighbour.cost;
                
                if(cost+currCost < distance[destination] && stops <= k){
                    distance[destination] = cost + currCost;
                    q.add(new Triple(stops+1, destination, cost+currCost));
                }
            }
        }
        
        return distance[dst] == Integer.MAX_VALUE ? -1 : distance[dst];
    }
}

class Pair{
    int des, cost;
    Pair(int d, int c){
        des = d;
        cost = c;
    }
}

class Triple{
    int stops, node, cost;
    Triple(int s, int n, int c){
        stops = s;
        node = n;
        cost = c;
    }
}