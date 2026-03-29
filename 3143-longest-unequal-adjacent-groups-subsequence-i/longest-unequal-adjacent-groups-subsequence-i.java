class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        int last = groups[0];
        List<String> ans = new ArrayList<>();
        ans.add(words[0]);
        for(int i=1; i<words.length; i++){
            if(groups[i] != last){
                last = groups[i];
                ans.add(words[i]);
            }
        }

        return ans;
    }
}