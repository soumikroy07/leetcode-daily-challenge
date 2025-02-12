class Solution {
    public int maximumSum(int[] nums) {
        int n = nums.length;
        int dig[] = new int[n];

        for(int i=0; i<n; i++){
            dig[i] = getDigit(nums[i]);
        }

        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();

        for(int i=0; i<n; i++){
            int digit = dig[i];
            int val = nums[i];
            if(map.containsKey(digit)){
                PriorityQueue<Integer> pq = map.get(digit);
                if(pq.size() < 2){
                    pq.add(val);
                }else{
                    if(pq.peek() < val){
                        pq.poll();
                        pq.add(val);
                    }
                }
            }else{
                PriorityQueue<Integer> pq = new PriorityQueue<>();
                pq.add(val);
                map.put(digit, pq);
            }
        }

        int ans = -1;
        for(Map.Entry<Integer, PriorityQueue<Integer>> m : map.entrySet()){
            PriorityQueue<Integer> pq = m.getValue();
            if(pq.size() == 2){
                int curr = 0;
                while(!pq.isEmpty()){
                    curr += pq.poll();
                }
                ans = Math.max(curr, ans);
            }
        }
        return ans;
    }

    int getDigit(int num){
        int ans = 0;
        while(num > 0){
            ans += num % 10;
            num = num / 10;
        }
        return ans;
    }
}