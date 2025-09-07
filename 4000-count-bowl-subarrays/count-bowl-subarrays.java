class Solution {
    public long bowlSubarrays(int[] nums) {
        int n = nums.length;
        int previousGreater[] = findPrevGreater(nums);
        int nextGreater[] = findNextGreater(nums);

        int count = 0;
        for (int i = 0; i < n; i++) {
            int start = previousGreater[i];
            int end = nextGreater[i];
            if (start != -1 && i - start + 1 >= 3) {
                count++;
            }

            if (end != -1 && end - i + 1 >= 3) {
                count++;
            }
        }

        return count;
    }

    int[] findPrevGreater(int nums[]) {
        int n = nums.length;
        int arr[] = new int[n];
        Arrays.fill(arr, -1);
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (st.size() > 0 && nums[st.peek()] < nums[i]) {
                st.pop();
            }
            if (!st.isEmpty()) {
                arr[i] = st.peek();
            }
            st.push(i);
        }

        return arr;
    }

    int[] findNextGreater(int nums[]) {
        int n = nums.length;
        int arr[] = new int[n];
        Arrays.fill(arr, -1);
        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (st.size() > 0 && nums[st.peek()] < nums[i]) {
                st.pop();
            }
            if (!st.isEmpty()) {
                arr[i] = st.peek();
            }
            st.push(i);
        }

        return arr;
    }
}