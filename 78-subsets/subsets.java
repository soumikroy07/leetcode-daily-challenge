class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        help(nums, 0);
        return ans;
    }

    void help(int nums[], int i){
        if(i == nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }
        help(nums, i+1);
        list.add(nums[i]);
        help(nums, i+1);
        list.remove(list.size() - 1);
    }
}