class Solution {
    public boolean halvesAreAlike(String s) {
        int n = s.length();
        int first = 0, second = 0;
        for(int i=0; i<n/2; i++){
            char c = s.charAt(i);
            if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U'){

                first++;
            }
        }
        
        for(int i=n/2; i<n; i++){
            char c = s.charAt(i);
            if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U'){
                second++;
            }
        }
        
        return first == second;
    }
}