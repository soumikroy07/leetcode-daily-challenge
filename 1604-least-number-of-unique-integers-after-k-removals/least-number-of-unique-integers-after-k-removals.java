class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int a: arr){
            map.put(a, map.getOrDefault(a, 0) + 1);
        }

        // int freq[][] = new int[map.size()][2];

        // int i=0;
        // for(Map.Entry<Integer, Integer> m: map.entrySet()){
        //     freq[i][0] = m.getKey();
        //     freq[i][1] = m.getValue();
        //     i++;
        // }

        // Arrays.sort(freq, (a, b) -> a[1] - b[1]);

        // for(i=0; i<freq.length; i++){
        //     if()
        // }

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