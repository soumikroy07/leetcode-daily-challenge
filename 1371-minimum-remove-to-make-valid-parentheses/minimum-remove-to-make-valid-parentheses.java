class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> st = new Stack<>();
        char str[] = s.toCharArray();

        for(int i=0; i<str.length; i++){
            if(Character.isLetter(str[i])){
                continue;
            }else{
                if(str[i] == '('){
                    st.push(i);
                }else if(!st.isEmpty() && str[st.peek()] == '('){
                    st.pop();
                }else{
                    st.push(i);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=str.length-1; i >= 0; i--){
            if(Character.isLetter(str[i])){
                sb.append(str[i]);
            }else{
                if(!st.isEmpty() && i == st.peek()){
                    st.pop();
                }else{
                    sb.append(str[i]);
                }
            }
        }

        return sb.reverse().toString();
    }
}