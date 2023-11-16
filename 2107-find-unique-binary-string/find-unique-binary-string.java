class Solution {
    public String findDifferentBinaryString(String[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int size = 1, num = 2;

        while(size <= 16){
            map.put(size, num);
            size++;
            num = num * 2;
        }

        int n = nums.length;
        Set<String> set = new HashSet<>();
        for(String s : nums){
            set.add(s);
        }

        int start = map.get(n)-1;

        while(start >= 0){
            String binary = getBinary(start, n);
            if(!set.contains(binary)){
                return binary;
            }
            start--;
        }

        return "";
    }

    String getBinary(int num, int size){
        if(num == 0){
            return "0";
        }
        Stack<Integer> st = new Stack<>();
        while(num > 0){
            st.push(num % 2);
            num = num / 2;
        }

        StringBuilder sb = new StringBuilder();
        while(st.size() < size){
            st.push(0);
        }
        while(!st.isEmpty()){
            sb.append(st.pop());
        }

        return sb.toString();
    }
}