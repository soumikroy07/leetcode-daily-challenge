class Solution {
    private static int mod = (int)1e9+7;
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        Stack<Integer> leftMin = new Stack<>();
        Stack<Integer> rightMin = new Stack<>();
        int noOfLeftMin[] = new int[n];
        int noOfRightMin[] = new int[n];
        
        leftMin.push(-1);
        rightMin.push(n);
        
        for(int i=0; i<n; i++){
            while(leftMin.peek() != -1 && arr[leftMin.peek()] > arr[i]){
                leftMin.pop();
            }
            noOfLeftMin[i] = i - leftMin.peek();
            leftMin.push(i);
        }
        
        for(int i=n-1; i>=0; i--){
            while(rightMin.peek() != n && arr[rightMin.peek()] >= arr[i]){
                rightMin.pop();
            }
            noOfRightMin[i] = rightMin.peek() - i;
            rightMin.push(i);
        }
        
        long res = 0;
        for(int i=0; i<n; i++){
            res = (res+((long)arr[i] * noOfLeftMin[i] * noOfRightMin[i])%mod)%mod;
            
        }
        
        return (int)res;
    }
}