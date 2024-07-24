class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        /*
        int n = nums.length;
        int arr[][] = new int[n][2];
        for(int i=0; i<n; i++){
            arr[i][1] = getValue(mapping, nums[i]);
            arr[i][0] = nums[i];
        }

        Arrays.sort(arr, (a, b) -> a[1] - b[1]);
        for(int i=0; i<n; i++){
            nums[i] = arr[i][0];
        }
        return nums;
        */
        List<int[]> mappedList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            String s = Integer.toString(nums[i]);
            StringBuilder n = new StringBuilder();
            for (char ch : s.toCharArray()) {
                n.append(mapping[ch - '0']);
            }
            mappedList.add(new int[]{nums[i], Integer.parseInt(n.toString()), i});
        }

        mappedList.sort((a, b) -> {
            if (a[1] != b[1]) {
                return Integer.compare(a[1], b[1]);
            } else {
                return Integer.compare(a[2], b[2]);
            }
        });
        int[] sortedNums = new int[nums.length];
        for (int i = 0; i < mappedList.size(); i++) {
            sortedNums[i] = mappedList.get(i)[0];
        }
        return sortedNums;
    }

    int getValue(int map[], int n){
        StringBuilder sb = new StringBuilder();
        while(n > 0){
            int val = n % 10;
            sb.append(map[val]);
            n = n / 10;
        }
        return Integer.parseInt(sb.reverse().toString());
    }
}