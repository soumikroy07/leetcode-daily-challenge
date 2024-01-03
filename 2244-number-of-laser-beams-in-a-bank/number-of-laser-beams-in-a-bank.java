class Solution {
    public int numberOfBeams(String[] bank) {
        int prev = 0;
        for(int i=0; i<bank[0].length(); i++){
            if(bank[0].charAt(i) == '1'){
                prev++;
            }
        }

        int ans = 0;
        for(int i=1; i<bank.length; i++){
            String str = bank[i];
            int curr = 0;
            for(char c: str.toCharArray()){
                curr += c == '1' ? 1 : 0;
            }
            ans += (prev * curr);
            if(curr != 0){
                prev = curr;
            }
        }
        return ans;
    }
}