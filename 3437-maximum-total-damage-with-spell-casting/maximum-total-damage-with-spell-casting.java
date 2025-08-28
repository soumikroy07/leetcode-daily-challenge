class Solution {
    Map<Integer, Integer> map;
    long dp[];
    public long maximumTotalDamage(int[] power) {
        dp = new long[power.length + 1];
        map = new HashMap<>();
        for(int p: power){
            map.put(p, map.getOrDefault(p, 0) + 1);
        }

        int arr[] = new int[map.size()];
        int i = 0;
        for(Map.Entry<Integer, Integer>m: map.entrySet()){
            arr[i++] = m.getKey();
        }
        Arrays.sort(arr);

        return help(arr, 0);

        /*
        Arrays.sort(power);
        return help(power, 0, new HashSet<Integer>());
        */
    }

    long help(int arr[], int i){
        if(i >= arr.length){
            return 0;
        }

        if(dp[i] != 0){
            return dp[i];
        }

        long notPick = help(arr, i+1);
        long pick = (long)arr[i] * map.get(arr[i]);
        if(i+1 < arr.length && arr[i+1] > arr[i]+2){
            pick += help(arr, i+1);
        }else if(i+2 < arr.length && arr[i+2] > arr[i]+2){
            pick += help(arr, i+2);
        }else{
            pick += help(arr, i+3);
        }

        return dp[i]=Math.max(pick, notPick);
    }

    long help(int power[], int i, Set<Integer> set){
        if(i >= power.length){
            return 0L;
        }
        long ans1 = 0L, ans2 = 0L;
        if(set.contains(power[i])){
            return help(power, i+1, set);
        }
        ans2 = help(power, i+1, set);
        set.add(power[i]-2);
        set.add(power[i]-1);
        set.add(power[i]+1);
        set.add(power[i]+2);
        ans2 = help(power, i+1, set) + (long)power[i];
        set.remove(power[i]-2);
        set.remove(power[i]-1);
        set.remove(power[i]+1);
        set.remove(power[i]+2);
        

        return Math.max(ans1, ans2);
    }
}