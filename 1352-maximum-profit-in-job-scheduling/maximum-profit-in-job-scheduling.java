class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = endTime.length;
        int[][] jobs = new int[n][3];
        for(int i=0; i<n; i++){
            jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }
        
        Arrays.sort(jobs, (a, b) -> a[1] - b[1]);
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(0, 0);
        for(int job[] : jobs){
            int value = job[2] + map.floorEntry(job[0]).getValue();
            if(value > map.lastEntry().getValue()){
                map.put(job[1], value);
            }
        }
        
        return map.lastEntry().getValue();
    }
}

/*

class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profits) {
        int n = endTime.length;
        Job jobs[] = new Job[n];
        // Arrays.sort(jobs);
        for(int i=0; i<n; i++){
            jobs[i] = new Job(startTime[i], endTime[i], profits[i]);
        }
        
        return help(jobs, 0, 0);
    }
    
    int help(Job jobs[], int endTime, int i){
        if(i >= jobs.length){
            return 0;
        }
        int profit = 0;
        if(endTime <= jobs[i].start){
            int profit1 = jobs[i].profit + help(jobs, jobs[i].end, i+1);
            int profit2 = help(jobs, endTime, i+1);
            profit += Math.max(profit1, profit2);
        }else{
            profit += help(jobs, endTime, i+1);
        }
        
        return profit;
    }
}

class Job implements Comparable<Job>{
    int start, end, profit;
    public Job(int s, int e, int p){
        start = s;
        end = e;
        profit = p;
    }
    
    public int compareTo(Job j){
        return this.start - j.start;
    }
}

*/