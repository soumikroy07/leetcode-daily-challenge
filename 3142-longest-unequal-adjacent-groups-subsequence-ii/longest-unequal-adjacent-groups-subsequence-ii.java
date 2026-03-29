class Solution {
    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        List<String> ans = new ArrayList<>();
        // if(words.length == 1){
        //     ans.add(words[0]);
        //     return ans;
        // }
        int n = words.length;
        int lis[] = new int[n];
        Arrays.fill(lis, 1);
        int maxLength = 1;

        for (int i = 1; i<n; i++){
            for (int j=i-1; j >= 0; j--){
                if(groups[i] != groups[j] && isHammingDistance(words[i], words[j])){
                    lis[i] = Math.max(lis[i], lis[j] + 1);
                    maxLength = Math.max(lis[i], maxLength);
                }
            }
        }

        String prev = "";
        int lastGroup = -1;
        for (int i=n-1; i>=0; i--){
            if(lis[i] == maxLength && prev.length() == 0){
                prev = words[i];
                ans.add(prev);
                maxLength--;
                lastGroup = groups[i];
            }

            if(lis[i] == maxLength && isHammingDistance(prev, words[i]) && lastGroup != groups[i]){
                maxLength--;
                prev = words[i];
                ans.add(0, prev);
                lastGroup = groups[i];
            }
        }
        return ans;
    }

    static boolean isHammingDistance(String s, String t){
        if(s.length() != t.length()){
            return false;
        }
        /*
        Map<Character, Integer> map = new HashMap<>();
        for (char c: s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c: t.toCharArray()){
            if(map.containsKey(c)){
                map.put(c, map.get(c) - 1);
                if(map.get(c) == 0){
                    map.remove(c);
                }
            }
        }

        if(map.size() > 1){
            return false;
        }

        return map.values().stream().findFirst().orElse(2) == 1;
        */
        int count = 0;
        for (int i=0; i<s.length(); i++){
            if(s.charAt(i) != t.charAt(i)){
                count++;
            }
        }

        return  count <= 1;
    }
}