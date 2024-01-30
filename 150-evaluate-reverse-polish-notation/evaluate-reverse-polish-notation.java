class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for(String s : tokens){
            if(s.equals("+")){
                if(st.size() > 1){
                    int val2 = st.pop();
                    int val1 = st.pop();
                    st.push(val1 + val2);
                }
            }else if(s.equals("-")){
                if(st.size() > 1){
                    int val2 = st.pop();
                    int val1 = st.pop();
                    st.push(val1 - val2);
                }
            }else if(s.equals("*")){
                if(st.size() > 1){
                    int val2 = st.pop();
                    int val1 = st.pop();
                    st.push(val1 * val2);
                }
            }else if(s.equals("/")){
                if(st.size() > 1){
                    int val2 = st.pop();
                    int val1 = st.pop();
                    st.push(val1 / val2);
                }
            }else{
                int val = getInt(s);
                st.push(val);
            }
        }
        return st.peek();
    }

    int getInt(String s){
        int val = 0;
        if(s.charAt(0) != '-'){
            for(char c : s.toCharArray()){
                val = 10*val + c - '0';
            }
        }else{
            for(int i=1; i<s.length(); i++){
                val = 10*val + s.charAt(i) - '0';
            }
            val = val * -1;
        }
        return val;
    }
}