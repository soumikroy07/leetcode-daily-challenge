class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int total = 0, i=0, j=0;
        while(i < g.length && j < s.length){
            if(s[j] >= g[i]){
                total++;
                i++;
                j++;
            }else{
                j++;
            }
        }
        
        return total;
    }
}