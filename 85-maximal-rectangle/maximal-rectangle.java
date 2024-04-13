class Solution {
    public int maximalRectangle(char[][] matrix) {
        int heights[] = new int[matrix[0].length];
        
        for(int i=0; i<matrix[0].length; i++){
            if(matrix[0][i] == '1'){
                heights[i] = 1;
            }else{
                heights[i] = 0;
            }
        }
        
        int maxArea = maxAreaHistogram(heights);
        
        for(int i=1; i<matrix.length; i++){
            for(int j=0; j<matrix[i].length; j++){
                if(matrix[i][j] == '1'){
                    heights[j] += 1;
                }else{
                    heights[j] = 0;
                }
            }
            int area = maxAreaHistogram(heights);
            maxArea = Math.max(maxArea, area);
        }
        
        return maxArea;
    }
    
    int maxAreaHistogram(int heights[]){
        
        int leftBound[] = new int[heights.length];
        
        leftBound[0] = -1;
        Stack<Integer> left = new Stack<>();
        left.push(0);
        
        for(int i=1; i<heights.length; i++){
            if(!left.isEmpty()){
                 while(heights[left.peek()] >= heights[i]){
                     left.pop();
                     if(left.isEmpty()){
                        left.push(i);
                        leftBound[i] = -1;
                        break;
                    }
                 }
                if(heights[left.peek()] < heights[i]){
                    leftBound[i] = left.peek();
                    left.push(i);
                }
            }
            
        }
        
        Stack<Integer> right = new Stack<>();
        int rightBound[] = new int[heights.length];
        rightBound[heights.length - 1] = heights.length;
        right.push(heights.length - 1);
        
        for(int i=heights.length - 2; i>=0; i--){
            if(!right.isEmpty()){
                while(heights[right.peek()] >= heights[i]){
                    right.pop();
                    if(right.isEmpty()){
                        right.push(i);
                        rightBound[i] = heights.length;
                        break;
                    }
                }
                if(heights[right.peek()] < heights[i]){
                    rightBound[i] = right.peek();
                    right.push(i);
                }
            }
            
        }
        int maxArea = 0;
        for(int i=0; i<heights.length; i++){
            int length = rightBound[i] - leftBound[i] - 1;
            int area = heights[i] * length;
            maxArea = Math.max(area, maxArea);
        }
        
        return maxArea;
        
        /*
        
        int maxArea = 0;
        int n = heights.length;
        if(n == 1){
            return heights[0];
        }
        int rightBound[] = new int[n];
        Stack<Integer> st1 = new Stack<>();
        // base case
        st1.push(n-1);
        rightBound[n-1] = n;
        
        // Build the array
        
        for(int i=n-2; i>=0; i--){
            while(heights[st1.peek()] >= heights[i]){
                st1.pop();
                if(st1.isEmpty()){
                    rightBound[i] = n;
                    st1.push(i);
                    break;
                }
            }
            if(heights[st1.peek()] < heights[i]){
                rightBound[i] = st1.peek();
                st1.push(i);
            }
        }
        
        int leftBound[] = new int[n];
        Stack<Integer> st2 = new Stack<>();
        
        //Base case
        // st2.push(-1);
        st2.push(0);
        leftBound[0] = -1;
        for(int i=1; i<n; i++){
            while(heights[st2.peek()] >= heights[i]){
                st2.pop();
                if(st2.isEmpty()){
                    st2.push(i);
                    leftBound[i] = -1;
                    break;
                }
            }
            if(heights[st2.peek()] < heights[i]){
                leftBound[i] = st2.peek();
                st2.push(i);
            }
        }
        
        for(int i=0; i<n; i++){
            int width = rightBound[i] - leftBound[i] - 1;
            int area = heights[i] * width;
            maxArea = Math.max(area, maxArea);
        }
        
        return maxArea;
        */
    }
}