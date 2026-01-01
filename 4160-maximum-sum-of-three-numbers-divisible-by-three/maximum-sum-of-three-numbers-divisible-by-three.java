class Solution {
    public int maximumSum(int[] nums) {
        Arrays.sort(nums);

        List<Integer> m0 = new ArrayList<>();
        List<Integer> m1 = new ArrayList<>();
        List<Integer> m2 = new ArrayList<>();

        for(int i=nums.length-1; i>=0; i--){
            int num = nums[i];
            if(num % 3 == 0){
                m0.add(num);
            }else if(num % 3 == 1){
                m1.add(num);
            }else{
                m2.add(num);
            }
        }


        int ans = 0;
        if(m0.size() >= 3){
            ans = Math.max(ans, m0.get(0) + m0.get(1) + m0.get(2));
        }

        if(m1.size() >= 3){
            ans = Math.max(ans, m1.get(0) + m1.get(1) + m1.get(2));
        }

        if(m2.size() >= 3){
            ans = Math.max(ans, m2.get(0) + m2.get(1) + m2.get(2));
        }

        if(!m0.isEmpty() && !m1.isEmpty() && !m2.isEmpty()){
            ans = Math.max(ans, m0.get(0) + m1.get(0) + m2.get(0));
        }

        return ans;
    }
}