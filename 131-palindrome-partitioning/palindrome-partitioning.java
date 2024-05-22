class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> list = new ArrayList<>();
        rec(0, s, list, ans);
        return ans;
    }

    void rec(int idx, String s, List<String> list, List<List<String>> ans) {
        if(idx == s.length()){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i=idx; i<s.length(); i++){
            if(isPalindrome(s, idx, i)){
                list.add(s.substring(idx, i+1));
                rec(i+1, s, list, ans);
                list.remove(list.size() - 1);
            }
        }
    }

    boolean isPalindrome(String s, int i, int j){
        while(i < j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}