class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num: nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int arr[][] = new int[map.size()][2];
        int i=0;
        for(Map.Entry<Integer, Integer> m : map.entrySet()){
            arr[i][0] = m.getKey();
            arr[i][1] = m.getValue();
            i++;
        }

        Arrays.sort(arr, (a, b) -> a[1] == b[1] ? b[0] - a[0] : a[1] - b[1]);

        int k=0;
        for(int j=0; j<arr.length; j++){
            int count = arr[j][1];
            while(count-- > 0){
                nums[k++] = arr[j][0];
            }
        }

        return nums;
    }
}