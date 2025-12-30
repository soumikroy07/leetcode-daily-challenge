class Solution {
    public int smallestRepunitDivByK(int k) {
        int count = 1;
        int num = 1;
        Set<Integer> set = new HashSet<>();
        while(num % k != 0){
            int rem = num % k;
            if(set.contains(rem)){
                return -1;
            }
            set.add(rem);
            num = rem * 10 + 1;
            count++;
        }
        
        return count;
    }
}