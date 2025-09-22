class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean visited[] = new boolean[n];
        help(rooms, 0, visited);
        for(int i=0; i<n; i++){
            if(!visited[i]){
                return false;
            }
        }

        return true;
    }

    private void help(List<List<Integer>> rooms, int start, boolean visited[]){
        visited[start] = true;
        List<Integer> keys = rooms.get(start);
        for(Integer key: keys){
            if(!visited[key]){
                help(rooms, key, visited);
            }
        }
    }
}