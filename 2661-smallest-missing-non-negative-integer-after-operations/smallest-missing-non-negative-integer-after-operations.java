class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        // Set<Integer> set = new HashSet<>();
        // for (int i = 0; i < nums.length; i++) {
        //     int num = nums[i] % value;
        //     int j = 0;
        //     while(set.contains(num)){
        //         num = value * j + num;
        //         j++;
        //     }
        //     set.add(num);
        //     // if(!set.contains(num)){
        //     //     set.add(num);
        //     //     j = 0;
        //     // }
        // }



        // for (int i = 0; ; i++) {
        //     if (!set.contains(i)) {
        //         return i;
        //     }
        // }

        // // return -1;

        int count[] = new int[value];
        for(int i=0; i<nums.length; i++){
            int num = nums[i] % value;
            if(num < 0){
                num += value;
            }
            count[num]++;
        }

        Set<Integer> set = new HashSet<>();

        for(int i=0; i<value; i++){
            int num_count = count[i];
            for(int j=0; j<num_count; j++){
                int curr = j * value + i;
                set.add(curr);
            } 
        }

        for (int i = 0; ; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }

    }
}
