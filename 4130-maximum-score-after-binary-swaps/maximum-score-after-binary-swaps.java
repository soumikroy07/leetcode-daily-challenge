class Solution {
    public long maximumScore(int[] nums, String s) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        long sum = 0;
        for(int i=0; i<nums.length; i++){
            pq.add(nums[i]);
            if(s.charAt(i) == '1'){
                sum += (long)pq.poll();
            }
        }

        return sum;
    }
}