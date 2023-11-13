class Solution {
    public String sortVowels(String s) {
        List<Character> vowels = new ArrayList<>();
        for(char c: s.toCharArray()){
            if(c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U' || c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'){
                vowels.add(c);
            }
        }

        Collections.sort(vowels);

        StringBuilder sb = new StringBuilder();

        int j = 0;
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U' || c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'){
                sb.append(vowels.get(j++));
            }else{
                sb.append(c);
            }
        }

        return sb.toString();
    }
}