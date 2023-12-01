class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        String temp1 = "", temp2 = "";
        
        for(String word : word1){
            temp1 += word;
        }
        
        for(String word : word2){
            temp2 += word;
        }
        
        if(temp1.equals(temp2)){
            return true;
        }
        
        return false;
    }
}