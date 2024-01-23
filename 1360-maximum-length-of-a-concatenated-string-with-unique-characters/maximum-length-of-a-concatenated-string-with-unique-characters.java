class Solution {
    public int maxLength(List<String> arr) {
        int max[] = new int[1];
        length(arr, 0, "", max);
        return max[0];
    }
    
    void length(List<String> arr, int idx, String path, int max[]){
        if(idx == arr.size()){
            if(isUnique(path)){
                max[0] = Math.max(max[0], path.length());
            }
            return;
        }
        length(arr, idx+1, path+arr.get(idx), max);
        length(arr, idx+1, path, max);
    }
    
    boolean isUnique(String temp){
        HashSet<Character> set = new HashSet<>();
        for(char c : temp.toCharArray()){
            if(set.contains(c)){
                return false;
            }
            set.add(c);
        }
        return true;
    }
}