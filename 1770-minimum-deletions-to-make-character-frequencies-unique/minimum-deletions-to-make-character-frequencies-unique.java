class Solution {
    public int minDeletions(String s) {
        int freq[] = new int[26];

        for(char c: s.toCharArray()){
            freq[c - 'a']++;
        }

        Set<Integer> set = new HashSet<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int f: freq){
            if(f != 0){
                pq.add(f);
            }
        }

        int ans = 0;
        while(!pq.isEmpty()){
            int curr = pq.poll();
            while(set.contains(curr)){
                curr--;
                ans++;
                if(curr == 0){
                    break;
                }
            }

            if(curr != 0 && !set.contains(curr)){
                set.add(curr);
            }
        }
        return ans;
    }
}