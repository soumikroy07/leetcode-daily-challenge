class Solution {
    public int maximumGap(String skill, String station) {
        int n = skill.length(), m = station.length();
        int left[] = new int[n];
        int right[] = new int[n];

        int i = 0, j = 0;

        while(i < n){
            if(skill.charAt(i) == station.charAt(j)){
                left[i] = j;
                i++;
                j++;
            }else{
                j++;
            }
        }

        j = m-1;
        i = n-1;

        while(i >= 0 && j >= 0){
            if(skill.charAt(i) == station.charAt(j)){
                right[i] = j;
                i--;
                j--;
            }else{
                j--;
            }
        }

        int ans = 0;
        for(i=n-1; i>0; i--){
            ans = Math.max(ans, right[i] - left[i-1]);
        }

        return ans;
    }
}