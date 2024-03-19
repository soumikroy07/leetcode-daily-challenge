class Solution {
    public int leastInterval(char[] tasks, int n) {
        int freq[] = new int[26];

        for(char task: tasks){
            freq[task - 'A']++;
        }

        Arrays.sort(freq);

        int maxFreq = freq[25];
        int idle = (maxFreq - 1) * n;

        for(int i=0; i<25; i++){
            idle -= Math.min(freq[i], freq[25]-1);
        }

        return tasks.length+Math.max(idle, 0);
    }
}