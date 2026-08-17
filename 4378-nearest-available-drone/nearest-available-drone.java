class Solution {
    public int nearestDrone(int[][] drones, int[] target) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);

        for(int i=0; i<drones.length; i++){
            int x = drones[i][0], y = drones[i][1], range = drones[i][2];
            int dist = Math.abs(x - target[0]) + Math.abs(y - target[1]);
            if(dist <= range){
                pq.add(new int[]{dist, i});
            }
        }

        return pq.size() > 0 ? pq.peek()[1] : -1;
    }
}