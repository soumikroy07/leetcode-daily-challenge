class Solution {
    int height = 1;
    public long weightedSum(int[] parent, int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int root = -1;
        int n = parent.length;
        for (int i=0; i<n; i++){
            int p = parent[i];
            if(p == -1){
                root = i;
                continue;
            }
            if(map.containsKey(p)){
                List<Integer> list = map.get(p);
                list.add(i);
                map.put(p, list);
            }else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(p, list);
            }
        }

        getHeight(map, root, 1);
        System.out.println(height);

        long total = getTotalWeight(map, root, nums, 1);

        return total;
    }

    private long getTotalWeight(Map<Integer, List<Integer>> map, int root, int[] nums, int level) {
        long ans = (long) nums[root] * (long) (height - level + 1);

        // 2. Add children's accumulated weights
        if (map.containsKey(root)) {
            for (int ch : map.get(root)) {
                ans += getTotalWeight(map, ch, nums, level + 1); // Add recursive result!
            }
        }

        return ans;
    }

    private void getHeight(Map<Integer, List<Integer>> map, int root, int h) {
        if(map.get(root) == null){
            return;
        }

        for(int ch: map.get(root)){
            height = Math.max(height, h+1);
            getHeight(map, ch, h+1);

        }

    }
}