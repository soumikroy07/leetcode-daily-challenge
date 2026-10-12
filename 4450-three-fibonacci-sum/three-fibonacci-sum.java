class Solution {
    public boolean threeFibonacciSum(int n) {
        List<Integer> list = new ArrayList<>();
        int i = 0, j = 1;
        list.add(0);
        while (j <= n) {
            // list.add(i);
            list.add(j);
            int sum = i + j;
            i = j;
            j = sum;
        }

        i = list.size() - 1;
        while(i >= 2){
            int sum = list.get(i) + list.get(i-1) + list.get(i-2);
            if(sum == n){
                return true;
            }
            i--;
        }

        return false;
    }
}