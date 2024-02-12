class Solution {
    public int majorityElement(int[] a) {
        int majority = a[0];
        int count = 1;
        
        for(int i = 1; i<a.length; i++){
            if(a[i] == majority){
                count++;
            }else{
                count --;
                if(count == 0){
                    count = 1;
                    majority = a[i];
                }
            }
        }
        
        return majority;
    }
}