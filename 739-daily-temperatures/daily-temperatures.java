class Solution {
    public int[] dailyTemperatures(int[] temp) {
        int n = temp.length;
        Stack<Integer> st = new Stack<>();
        st.push(n-1);
        int ans[] = new int[n];
        ans[n-1] = 0;
        for(int i=n-2; i>=0; i--){
            while(!st.isEmpty() && temp[st.peek()] <= temp[i]){
                st.pop();
            }
            ans[i] = st.isEmpty() ? 0 : st.peek() - i;
            st.push(i);
        }

        return ans;
    }
}