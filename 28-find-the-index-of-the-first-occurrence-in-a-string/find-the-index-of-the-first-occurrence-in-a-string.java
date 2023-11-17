class Solution {
    public int strStr(String text, String pat) {
        int lps[] = getArray(pat);
        int n = text.length(), m = pat.length();
        int i=0, j = 0;

        while(i < n){
            if(text.charAt(i) == pat.charAt(j)){
                i++;
                j++;
                if(j == m){
                    return i - j;
                }
            }else if(i < n && text.charAt(i) != pat.charAt(j)){
                if(j == 0){
                    i++;
                }else{
                    j = lps[j-1];
                }
            }
        }
        return -1;
    }

    private int[] getArray(String pat){
        int n = pat.length();
        int lps[] = new int[n];
        lps[0] = 0;

        int len = 0, i = 1;
        while(i < n){
            if(pat.charAt(i) == pat.charAt(len)){
                len++;
                lps[i] = len;
                i++;
            }else{
                if(len == 0){
                    i++;
                }else{
                    len = lps[len-1];
                }
            }
        }
        return lps;
    }
}