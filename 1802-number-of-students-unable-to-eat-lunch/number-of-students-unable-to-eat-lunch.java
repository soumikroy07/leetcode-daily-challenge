class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int count[] = new int[2];
        for(int student: students){
            count[student]++;
        }

        for(int s: sandwiches){
            if(count[s] == 0){
                break;
            }
            count[s]--;
            
        }

        return count[0]+count[1];
    }
}