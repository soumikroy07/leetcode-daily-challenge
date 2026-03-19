import java.util.List;
import java.util.Stack;

class Solution {
    public long maximumSumOfHeights(List<Integer> maxHeights) {
        int n = maxHeights.size();
        long[] left = new long[n];
        long[] right = new long[n];
        Stack<Integer> stack = new Stack<>();

        // 1. Calculate the maximum sums for prefixes ending at peak 'i'
        for (int i = 0; i < n; i++) {
            // Pop elements that are taller than the current height
            while (!stack.isEmpty() && maxHeights.get(stack.peek()) >= maxHeights.get(i)) {
                stack.pop();
            }
            
            if (stack.isEmpty()) {
                // If everything before is taller, they all get bottlenecked to maxHeights[i]
                left[i] = (long) (i + 1) * maxHeights.get(i);
            } else {
                // Keep the sum of the valid prefix, bottleneck the middle gap
                int prev = stack.peek();
                left[i] = left[prev] + (long) (i - prev) * maxHeights.get(i);
            }
            stack.push(i);
        }

        // Clear the stack to reuse it for the right-to-left pass
        stack.clear();

        // 2. Calculate the maximum sums for suffixes starting at peak 'i'
        for (int i = n - 1; i >= 0; i--) {
            // Pop elements that are taller than the current height
            while (!stack.isEmpty() && maxHeights.get(stack.peek()) >= maxHeights.get(i)) {
                stack.pop();
            }
            
            if (stack.isEmpty()) {
                // If everything after is taller, they all get bottlenecked to maxHeights[i]
                right[i] = (long) (n - i) * maxHeights.get(i);
            } else {
                // Keep the sum of the valid suffix, bottleneck the middle gap
                int next = stack.peek();
                right[i] = right[next] + (long) (next - i) * maxHeights.get(i);
            }
            stack.push(i);
        }

        // 3. Find the global maximum by combining left and right peaks
        long maxSum = 0;
        for (int i = 0; i < n; i++) {
            // Subtract maxHeights.get(i) because it is counted in both left[i] and right[i]
            long currentSum = left[i] + right[i] - maxHeights.get(i);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}
/*
class Solution {
    public long maximumSumOfHeights(List<Integer> heights) {
        Stack<Integer> stack = new Stack<>();
        int n = heights.size();
        long left[] = new long[n];
        long right[] = new long[n];
        left[0] = heights.get(0);
        stack.push(0);


        for(int i=1; i<n; i++){
            while (!stack.isEmpty() && heights.get(stack.peek()) > heights.get(i)){
                stack.pop();
            }

            if(stack.isEmpty()){
                left[i] = (long)(i+1) * heights.get(i);
            }else {
                left[i] = (long)((i - stack.peek()) * heights.get(i)) + left[stack.peek()];
            }
            stack.push(i);
        }
        stack.clear();
        right[n-1] = heights.get(n-1);
        stack.push(n-1);

        for (int i=n-2; i>=0; i--){
            while (!stack.isEmpty() && heights.get(stack.peek()) > heights.get(i)){
                stack.pop();
            }

            if(stack.isEmpty()){
                right[i] = (long)(n - i) * heights.get(i);
            }else {
                right[i] = (long)((stack.peek() - i) * heights.get(i)) + right[stack.peek()];
            }
            stack.push(i);
        }
        long ans = 0;
        for (int i=0; i<n; i++){
            long sum = left[i] + right[i] - heights.get(i);
            ans = Math.max(ans, sum);
        }

        return ans;
    }
}
*/