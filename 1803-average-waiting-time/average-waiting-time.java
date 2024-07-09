class Solution {
    public double averageWaitingTime(int[][] cus) {
        double start = cus[0][0] + cus[0][1];
        double wait = cus[0][1];
        for(int i=1; i<cus.length; i++){
            // start = Math.max(cus[i][0], )
            if(start > cus[i][0]){
                wait = wait + (start - cus[i][0]);
            }
            wait += cus[i][1];
            start = Math.max(start+cus[i][1], cus[i][0]+cus[i][1]);
        }

        return (double)wait / (double) cus.length;
    }
}