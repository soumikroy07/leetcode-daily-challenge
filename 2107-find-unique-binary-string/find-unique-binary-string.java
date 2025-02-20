class Solution {
    Set<String> set;
    String ans = "";
    public String findDifferentBinaryString(String[] nums) {
        set = new HashSet<>();
        for(String num: nums){
            set.add(num);
        }
        StringBuilder sb = new StringBuilder();
        help(sb, nums[0].length());
        return ans;
    }

    boolean help(StringBuilder sb, int n){
        if(sb.length() == n){
            if(!set.contains(sb.toString())){
                ans = sb.toString();
                return true;
            }
            return false;
        }

        sb.append('0');
        if(help(sb, n)) return true;
        sb.setLength(sb.length() - 1);
        sb.append('1');
        if(help(sb, n)) return true;
        sb.setLength(sb.length() - 1);
        return false;
    }
}