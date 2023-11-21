/*
class Solution {
    public int countNicePairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for(int num: nums){
            int rev = reverse(num);
            int diff = Math.abs(num - rev);
            if(map.containsKey(diff)){
                count += map.get(diff);
            }
            map.put(diff, map.getOrDefault(diff, 0)+1);
        }
        return count;
    }

    int reverse(int num){
        int value = 0;
        while(num > 0){
            int val = num % 10;
            value = 10 * value + val;
            num /= 10;
        }
        return value;
    }
}

*/

class Solution {
    public int countNicePairs(int[] nums) {
        int mod=(int)Math.pow(10,9)+7;
        int count=0;
        
        HashMap<Long,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            long rev=reverse(nums[i]);
            
            long diff=nums[i]-rev;
            if(map.containsKey(diff)){
                count=(count%mod + map.get(diff)%mod)%mod;
            }
            
            map.put(diff,map.getOrDefault(diff,0)+1);
        } 
        
     return count;
    }
 
    private long reverse(int num){
        long rev=0;
        while(num!=0){
            rev=rev*10 + num%10;
            num/=10;
        }
        return rev;
    }
}