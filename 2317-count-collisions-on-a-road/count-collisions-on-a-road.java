class Solution {
    public int countCollisions(String dir) {
        int count = 0, ans = 0;
        boolean flag = false;

        for(char c: dir.toCharArray()){
            if(c == 'L'){
                if(flag && count == 0){
                    ans += 1;
                }else if(count > 0){
                    ans += count + 1;
                    count = 0;
                    flag = true;
                }
                
            }else if(c == 'R'){
                count += 1;
            }else{
                if(count > 0){
                    ans += count;
                    count = 0;
                    
                }
                flag = true;
            }
        }

        return ans;
    }
}