class Solution {
    public int countSeniors(String[] details) {
        int count = 0;
        for(String s: details){
            count += Integer.parseInt(s.substring(11,13)) > 60 ? 1 : 0;
        }
        return count;
    }
}