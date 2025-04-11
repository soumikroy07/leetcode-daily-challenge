class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int ans = 0;
        for(int i=low; i<=high; i++){
            if(i < 10){
                continue;
            }
            
            if(is(i)){
                ans++;
            }
        }
        
        return ans;
    }
    
    boolean is(int num){
        String s = num+"";
        if(s.length() % 2 != 0){
            return false;
        }
        
        int sum1 = 0, sum2 = 0;
        for(int i=0; i<s.length()/2; i++){
            sum1 += s.charAt(i) - '0';
            sum2 += s.charAt(s.length()- i- 1) - '0';
        }
        
        return sum1 == sum2;
    }
}