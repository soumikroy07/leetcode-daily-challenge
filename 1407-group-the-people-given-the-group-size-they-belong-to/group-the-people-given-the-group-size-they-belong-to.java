class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSize) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<List<Integer>> ans = new ArrayList<>();
        for (int i=0; i<groupSize.length; i++){
            if(map.containsKey(groupSize[i])){
                List<Integer> list = map.get(groupSize[i]);
                list.add(i);
                map.put(groupSize[i], list);
            }else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(groupSize[i], list);
            }

            if(map.get(groupSize[i]).size() == groupSize[i]){
                List<Integer> list = map.get(groupSize[i]);
                map.remove(groupSize[i]);
                ans.add(list);
            }
        }

        return ans;
    }
}