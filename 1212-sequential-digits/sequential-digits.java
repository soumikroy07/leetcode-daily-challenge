class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        Queue<Integer> q = new LinkedList<>();
        for(int i=1; i<=9; i++){
            q.add(i);
        }
        List<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            int num = q.poll();
            if(num >= low && num <= high){
                ans.add(num);
            }
            if(num > high){
                break;
            }

            if(num % 10 < 9){
                q.add(10*num + ((num % 10) + 1));
            }
        }

        return ans;
    }
}