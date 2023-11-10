class Solution {
    public int[] restoreArray(int[][] adj) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int a[] : adj){
            if(map.containsKey(a[0])){
                List<Integer> curr = map.get(a[0]);
                curr.add(a[1]);
                map.put(a[0], curr);
            }else{
                List<Integer> curr = new ArrayList<>();
                curr.add(a[1]);
                map.put(a[0], curr);
            }

            if(map.containsKey(a[1])){
                List<Integer> curr = map.get(a[1]);
                curr.add(a[0]);
                map.put(a[1], curr);
            }else{
                List<Integer> curr = new ArrayList<>();
                curr.add(a[0]);
                map.put(a[1], curr);
            }
        }

        int start = -1;
        for(Map.Entry<Integer, List<Integer>> m: map.entrySet()){
            if(m.getValue().size() == 1){
                start = m.getKey();
                break;
            }
        }
        Set<Integer> visited = new HashSet<>();
        dfs(start, map, visited, list);
        int n = list.size();
        int ans[] = new int[n];
        for(int i=0; i<n; i++){
            ans[i] = list.get(i);
        }
        return ans;
    }

    void dfs(int val, Map<Integer, List<Integer>> adj, Set<Integer> visited, List<Integer> list){
        visited.add(val);
        list.add(val);
        for(int curr: adj.get(val)){
            if(!visited.contains(curr)){
                dfs(curr, adj, visited, list);
            }
        }
    }
}