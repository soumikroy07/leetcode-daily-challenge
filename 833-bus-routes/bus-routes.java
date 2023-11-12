/*
class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        Map<Integer, int[]> map = new HashMap<>();

        for(int r[]: routes){
            for(int rt: r){
                map.put(rt, r);
            }
        }

        Set<Integer> visited = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        visited.add(source);
        int ans = 0;
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                int curr = q.poll();
                if(curr == target){
                    return ans;
                }
                int nei[] = map.get(curr);
                for(int ne: nei){
                    if(!visited.contains(ne)){
                        q.add(ne);
                        visited.add(ne);
                    }
                }
            }
            ans++;
        }
        return -1;
    }
}

*/

class Solution {
    public int numBusesToDestination(int[][] routes, int S, int T) {
       HashSet<Integer> visited = new HashSet<>();
       Queue<Integer> q = new LinkedList<>();
       HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
       int ret = 0; 
        
       if (S==T) return 0; 
        
       for(int i = 0; i < routes.length; i++){
            for(int j = 0; j < routes[i].length; j++){
                ArrayList<Integer> buses = map.getOrDefault(routes[i][j], new ArrayList<>());
                buses.add(i);
                map.put(routes[i][j], buses);                
            }       
        }
                
       q.offer(S); 
       while (!q.isEmpty()) {
           int len = q.size();
           ret++;
           for (int i = 0; i < len; i++) {
               int cur = q.poll();
               ArrayList<Integer> buses = map.get(cur);
               for (int bus: buses) {
                    if (visited.contains(bus)) continue;
                    visited.add(bus);
                    for (int j = 0; j < routes[bus].length; j++) {
                        if (routes[bus][j] == T) return ret;
                        q.offer(routes[bus][j]);  
                   }
               }
           }
        }
        return -1;
    }
}