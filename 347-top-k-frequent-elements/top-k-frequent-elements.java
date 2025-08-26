class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num: nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int arr[][] = new int[map.size()][2];

        int i = 0;
        for(Map.Entry<Integer, Integer> m: map.entrySet()){
            arr[i][0] = m.getKey();
            arr[i][1] = m.getValue();
            i += 1;
        }

        Arrays.sort(arr, (a, b) -> b[1] - a[1]);
        int ans[] = new int[k];
        i=0;
        while(k-- > 0){
            ans[i] = arr[i][0];
            i++;
        }

        return ans;
    }
}