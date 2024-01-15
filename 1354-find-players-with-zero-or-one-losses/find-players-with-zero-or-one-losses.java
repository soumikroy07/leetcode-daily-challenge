class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> win = new HashMap<>();
        Map<Integer, Integer> lost = new HashMap<>();
        for(int match[] : matches){
            win.put(match[0], win.getOrDefault(match[0], 0) + 1);
            lost.put(match[1], lost.getOrDefault(match[1], 0) + 1);
        }
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> winners = new ArrayList<>();
        List<Integer> loosers = new ArrayList<>();
        for(Map.Entry<Integer, Integer> l : lost.entrySet()){
            if(l.getValue() == 1){
                loosers.add(l.getKey());
            }
        }
        
        for(Map.Entry<Integer, Integer> w : win.entrySet()){
            if(!lost.containsKey(w.getKey())){
                winners.add(w.getKey());
            }
        }
        
        Collections.sort(loosers);
        Collections.sort(winners);
        ans.add(new ArrayList<>(winners));
        ans.add(new ArrayList<>(loosers));
        return ans;
    }
}