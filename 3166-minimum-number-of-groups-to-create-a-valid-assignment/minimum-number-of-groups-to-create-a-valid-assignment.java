import java.util.*;
class Solution {
    public int minGroupsForValidAssignment(int[] balls) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int ball: balls){
            map.put(ball, map.getOrDefault(ball, 0) + 1);
        }

        int min = Integer.MAX_VALUE;
        for(Map.Entry<Integer, Integer> m : map.entrySet()){
            min = Math.min(min, m.getValue());
        }

        int ans = 0;

        for(int x=min; x >= 1; x--){
            if(canPossible(map.values(), x)){
                int totalGroups = 0;
                for(int freq: map.values()){
                    totalGroups += (freq + x) / (x + 1);
                }
                return totalGroups;
            }
        }
        return -1;
    }

    boolean canPossible(Collection<Integer> freqency, int min){
        for(int freq: freqency){
            int p = freq / min;
            int r = freq % min;

            if(r > p){
                return false;
            }
        }

        return true;
    }

    boolean isValid(Map<Integer, Integer> map, int bags, int min){
        /*
        int noOfBagsReq = 0;

        for(Map.Entry<Integer, Integer> m: map.entrySet()){
            int noOfBalls = m.getValue();
            if(noOfBalls == min){
                noOfBagsReq++;
                continue;
            }

            int rem = noOfBalls % (min + 1);
            int noOfBag = noOfBalls / (min + 1);

            if(rem > 0){
                noOfBag++;
            }
            noOfBagsReq += noOfBag;
        }

        return noOfBagsReq <= bags;
        */

        int noOfBagsReq = 0;

        for(Map.Entry<Integer, Integer> m: map.entrySet()){
            int noOfBalls = m.getValue();
            int groups = noOfBalls / min;
            int ballsLeft = noOfBalls % min;

            if(groups < ballsLeft){
                noOfBagsReq++;
            }

            noOfBagsReq += groups;
        }

        return noOfBagsReq <= bags;
    }
}