class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n <= 0){
            return false;
        }
 
        if(n == 1){
            return true;
        }

        if(n % 2 != 0){
            return false;
        }
 
        // while(n > 1){
        //     if(n % 2 != 0){
        //         return false;
        //     }else{
        //         n /= 2;
        //     }
        // }

        // return true;

        return isPowerOfTwo(n / 2);
    }
}