class Solution {
    public boolean canMakeSubsequence(String s, String t) {
        int m = s.length(), n = t.length();
        int pre[] = new int[n+1], suf[] = new int[n+1];

        int idx = 0;
        for(int i=0; i<n; i++){
            pre[i+1] = pre[i];
            if(idx >= m) continue; 
            if(s.charAt(idx) == t.charAt(i)){
                pre[i+1]++;
                idx++;
            }
        }

        idx = m-1;
        for(int i=n-1; i>=0; i--){
            suf[i] = suf[i+1];
            if(idx == 0) continue;
            if(s.charAt(idx) == t.charAt(i)){
                suf[i]++;
                idx--;
            }
        }

        for(int i=0; i<n; i++){
            if(pre[i] + suf[i] >= m) return true;
            if(pre[i] + suf[i+1] >= m-1) return true;
        }
        return false;
    }
}