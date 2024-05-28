class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int n = s.length();
        int diff[] = new int[n];
        for(int i=0; i<n; i++){
            diff[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }
        int length = 0;
        int sum = 0, j = 0;
        for(int i=0; i<n; i++){
            sum += diff[i];
            while(sum > maxCost){
                sum -= diff[j];
                j++;
            }
            length = Math.max(length, i-j+1);
        }

        return length;
    }
}