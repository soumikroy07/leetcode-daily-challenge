class Solution {
    public int appendCharacters(String s, String t) {
        int n = t.length(), m = s.length();
        int i = 0, j = 0;
        while(i < m && j < n){
            if(s.charAt(i) == t.charAt(j)){
                i++;
                j++;
            }else{
                i++;
            }
        }
        
        if(j == n){
            return 0;
        }else{
            return n - j;
        }
    }
}