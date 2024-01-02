class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        int max = -1;
        List<List<Integer>> ans = new ArrayList<>();
        int freq[] = new int[201];
        for (int num : nums){
            freq[num]++;
            max = Math.max(max, freq[num]);
        }

        while(max-- > 0){
            List<Integer> list = new ArrayList<>();
            for(int i=0; i<=200; i++){
                if(freq[i] == 0){
                    continue;
                }
                list.add(i);
                freq[i]--;
            }
            ans.add(new ArrayList<>(list));
        }
        return ans;
    }
}