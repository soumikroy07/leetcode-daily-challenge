class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        int count = 0, n = words.length;
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                if(i != j){
                    String str1 = words[i];
                    String str2 = words[j];
                    int l1 = str1.length();
                    int l2 = str2.length();
                    if(l1 <= l2 && str2.substring(0, l1).equals(str1) &&
                        str2.substring(l2-l1).equals(str1)){
                            count += 1;
                        }
                }
            }
        }
        return count;
    }
}