class Solution {
    public String removeKdigits(String num, int k) {
        if(num.length() == k){
            return "0";
        }
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<num.length(); i++){
            while(k > 0 && !st.isEmpty() && st.peek() > num.charAt(i) - '0'){
                st.pop();
                k--;
            }
            st.push(num.charAt(i) - '0');
        }
        while(k > 0){
            st.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.insert(0, st.pop());
        }

        while(sb.length()>1 && sb.charAt(0)=='0')
            sb.deleteCharAt(0);
        return sb.toString();
    }
}