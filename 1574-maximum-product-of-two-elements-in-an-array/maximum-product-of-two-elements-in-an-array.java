class Solution {
    public int maxProduct(int[] nums) {
        int h1 = -1, h2 = -1;
        for(int num: nums){
            if(num >= h1){
                h2 = h1;
                h1 = num;
            }else if(num >= h2){
                h2 = num;
            }
        }

        return (h1-1)*(h2-1);
    }
}