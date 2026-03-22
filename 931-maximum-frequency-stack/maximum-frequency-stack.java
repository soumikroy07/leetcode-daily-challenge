class FreqStack {

    List<Stack<Integer>> bucket;
    HashMap<Integer, Integer> map;
    
    public FreqStack() {
        bucket = new ArrayList<>();
        map = new HashMap<>();
    }
    
    public void push(int x) {
        map.put(x, map.getOrDefault(x, 0) + 1);
        int freq = map.get(x);
        if (freq - 1 >= bucket.size()) {
            bucket.add(new Stack<Integer>());
        }
        bucket.get(freq - 1).add(x);
    }
    
    public int pop() {
        int freq = bucket.size();
        int x = bucket.get(freq - 1).pop();
        if (bucket.get(freq - 1).isEmpty()) bucket.remove(bucket.size() - 1);
        
        map.put(x, map.get(x) - 1);
        if (map.get(x) == 0) map.remove(x);
        
        return x;
    }
}

/*
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
        if(stack.containsKey(count)){
            Stack st = stack.get(count);
            st.push(val);
            stack.put(count, st);
        }else{
            Stack<Integer> st = new Stack<>();
            st.push(val);
            stack.put(count, st);
        }
        max = Math.max(max, count);
    }
    
    public int pop() {
        // if(max == 0){
        //     return -1;
        // }

        int ans = -1;
        Stack<Integer> st = stack.get(max);
        if(!st.isEmpty()) ans = st.pop();
        if(st.isEmpty()) max--;
        return ans;
    }
}
*/

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */