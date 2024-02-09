class Solution {
    List<Integer> ans;
    int mem[];
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        mem = new int[nums.length];
        Arrays.fill(mem, -1);
        ans = new ArrayList<>();
        helper(nums, 0, new ArrayList<Integer>(), 1);
        return ans;
    }
    
    void helper(int nums[], int index, List<Integer> curr, int currValue){
        if(curr.size() > ans.size()){
            ans = new ArrayList<>(curr);
        }
        
        for(int i=index; i<nums.length; i++){
            if(curr.size() > mem[i] && nums[i] % currValue == 0){
                mem[i] = curr.size();
                curr.add(nums[i]);
                helper(nums, i+1, curr, nums[i]);
                curr.remove(curr.size() - 1);
            }
        }
    }
}