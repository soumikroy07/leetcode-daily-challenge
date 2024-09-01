/*

class Solution {
    double ans = 0.0;
    public double maxProbability(int n, int[][] edges, double[] succ, int start, int end) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<Pair>());
        }

        int idx = 0;
        for(int edge[]: edges){
            int src = edge[0], dest = edge[1];
            double prob = succ[idx++];
            adj.get(src).add(new Pair(dest, prob));
            adj.get(dest).add(new Pair(src, prob));
        }

        boolean visited[] = new boolean[n];
        dfs(adj, start, end, visited, 1.0);
        return ans;
    }

    void dfs(List<List<Pair>> adj, int start, int end, boolean visited[], double succ){
        
        
        if(start == end){
            ans = Math.max(ans, succ);
            return;
        }
        visited[start] = true;

        for(Pair curr: adj.get(start)){
            int dest = curr.dest;
            if(!visited[dest]){
                dfs(adj, dest, end, visited, succ*curr.prob);
            }
        }

        visited[start] = false;

        

        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(start, 1.0));

        while(!q.isEmpty())
    }
}

class Pair{
    int dest;
    double prob;
    public Pair(int _d, double _p){
        dest = _d;
        prob = _p;
    }
}

*/
class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        Map<Integer, List<Pair<Integer, Double>>> graph = new HashMap<>();
        int [] edge;
        for(int  i = 0;i< edges.length;i++){
            edge = edges[i];
            graph.computeIfAbsent(edge[0],k->new ArrayList<>()).add(new Pair<>(edge[1],succProb[i]));
            graph.computeIfAbsent(edge[1],k->new ArrayList<>()).add(new Pair<>(edge[0],succProb[i]));
        }
        //System.out.println(graph);
        double [] maxProb = new double[n];
        maxProb[start] = 1.0;
        
        PriorityQueue<Pair<Integer,Double>> pq = new PriorityQueue<>((a,b)->-Double.compare(a.getValue(),b.getValue()));
        pq.add(new Pair<>(start,1.0));
        while (!pq.isEmpty()){
            
            Pair<Integer,Double> curr = pq.remove();
            if(curr.getKey()==end)return curr.getValue();
            for(Pair<Integer,Double> path: graph.getOrDefault(curr.getKey(),new ArrayList<>())){
                if(curr.getValue()* path.getValue()>maxProb[path.getKey()]){
                    maxProb[path.getKey()] = (double)curr.getValue()* path.getValue();
                    pq.add(new Pair<>(path.getKey(), maxProb[path.getKey()]));
                }
            }
        }
        return 0.0;
    }
}