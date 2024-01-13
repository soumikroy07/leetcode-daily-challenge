class Solution {
/*
    public int minSteps(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c: s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }

        for(char c: t.toCharArray()){
            if(!map.containsKey(c)){
                map.put(c, 1);
            }else{
                map.put(c, map.get(c)-1);
                if(map.get(c) == 0){
                    map.remove(c);
                }
            }
        }

        int ans = 0;
        for(Map.Entry<Character, Integer> m: map.entrySet()){
            ans += m.getValue();
        }
        return ans/2;
    }
*/
    public int minSteps(String s, String t) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            ++count[s.charAt(i) - 'a']; // count the occurrences of chars in s.
            --count[t.charAt(i) - 'a']; // compute the difference between s and t.
        }
     // return Arrays.stream(count).map(Math::abs).sum() / 2; // sum the absolute of difference and divide it by 2.
     // return Arrays.stream(count).filter(i -> i > 0).sum(); // sum the positive values.
        int steps = 0;
        for (int step : count) {
            if (step > 0) {
                steps += step;
            }
        }
	    return steps;
    }
}