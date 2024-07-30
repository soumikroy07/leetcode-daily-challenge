class Solution {
    public int minimumDeletions(String s) {
        int n = s.length();
        int rightA[] = new int[n];
        int leftB[] = new int[n];
        int count = 0;
        for(int i=0; i<n; i++){
            if(s.charAt(i) == 'b'){
                count++;
            }
            leftB[i] = count;
        }

        count = 0;
        for(int i=n-1; i>=0; i--){
            rightA[i] = s.charAt(i) == 'a' ? ++count : count;
        }

        int ans = Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            ans = Math.min(rightA[i] + leftB[i], ans);
        }

        return ans-1;
    }
}