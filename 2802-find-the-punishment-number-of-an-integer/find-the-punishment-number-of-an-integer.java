class Solution {
    List<Integer> list = new ArrayList<>();
    public int punishmentNumber(int n) {
        calculateInRange(n);
        int ans = 0;
        for(int val : list){
            ans += (val * val);
        }
        return ans;
    }

    void calculateInRange(int n){
        list.add(1);
        for(int i=2; i<=n ;i++){
            int num = i * i;
            if(isValid(Integer.toString(num), i)){
                list.add(i);
            }
        }
    }

    boolean isValid(String num, int sum){
        if(sum < 0){
            return false;
        }
        if(sum == 0 && num.isEmpty()){
            return true;
        }
        boolean ans = false;
        for(int i=0; i<num.length(); i++){
            String curr = num.substring(0, i+1);
            ans = ans || isValid(num.substring(i+1), sum-Integer.parseInt(curr));
        }
        return ans;
    }
}