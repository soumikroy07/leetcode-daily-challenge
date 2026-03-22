class FreqStack {
    Map<Integer, Stack<Integer>> stack;
    Map<Integer, Integer> freq;
    int max;

    public FreqStack() {
        stack = new HashMap<>();
        freq = new HashMap<>();
        max = 0;
    }

    public void push(int val) {
        freq.put(val, freq.getOrDefault(val, 0) + 1);
        int count = freq.get(val);
        if (stack.containsKey(count)) {
            Stack st = stack.get(count);
            st.push(val);
            stack.put(count, st);
        } else {
            Stack<Integer> st = new Stack<>();
            st.push(val);
            stack.put(count, st);
        }
        max = Math.max(max, count);
    }

    public int pop() {
        Stack<Integer> st = stack.get(max);
        int ans = st.pop();
        freq.put(ans, freq.get(ans) - 1);

        if (st.isEmpty()) {
            max--;
        }

        return ans;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */