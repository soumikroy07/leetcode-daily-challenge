class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        int idx1 = -1, idx2 = -1, i = 0, j = 0, n = s1.length();

        while(i < n){
            if(s1.charAt(i) != s2.charAt(j)){
                if(idx1 == -1){
                    idx1 = i;
                }else if(idx2 == -1){
                    idx2 = i;
                }else{
                    return false;
                }
            }
            i++;
            j++;
        }
        if(idx1 != -1 && idx2 == -1){
            return false;
        }else if(idx1 != idx2 && s1.charAt(idx1) != s2.charAt(idx2)){
            return false;
        }else if(idx1 != idx2 && s1.charAt(idx2) != s2.charAt(idx1)){
            return false;
        }
        return true;
    }
}