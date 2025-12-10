class Solution {
    public boolean isHappy(int n) {
        if(n == 1){
            return true;
        }
        Set<Integer> set = new HashSet<>();
        set.add(n);

        while(n != 1){
            int val = getNext(n);
            if(set.contains(val)){
                return false;
            }
            set.add(val);
            n = val;
        }

        return n == 1;
    }

    int getNext(int n){
        int val = 0;

        while(n != 0){
            int rem = n % 10;
            val = val + (rem * rem);
            n = n / 10;
        }

        return val;
    }
}