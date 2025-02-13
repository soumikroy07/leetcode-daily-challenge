class Solution {
    public int minOperations(int[] nums, int k) {
        /*
         * PriorityQueue<Integer> pq = new PriorityQueue<>();
         * for(int num: nums){
         * pq.add(num);
         * }
         * int count = 0;
         * while(pq.size() > 1){
         * int num1 = pq.poll();
         * int num2 = pq.poll();
         * if(num1 < k && num2 < k){
         * int curr = 2 * Math.min(num1, num2) + Math.max(num1, num2);
         * pq.add(curr);
         * count += 1;
         * }else{
         * break;
         * }
         * }
         * return count;
         */

        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        for (int n : nums)
            minHeap.add((long) n);
        int count = 0;
        for (; minHeap.peek() < k; ++count)
            minHeap.add(minHeap.poll() * 2L + minHeap.poll());
        return count;
    }
}