class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int a: arr){
            map.put(a, map.getOrDefault(a, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(Map.Entry<Integer, Integer> m: map.entrySet()){
            pq.add(m.getValue());
        }

        while(k > 0){
            int val = pq.peek();
            if(val <= k){
                pq.poll();
                k = k - val;
            }else{
                break;
            }
        }

        return pq.size();
    }
}