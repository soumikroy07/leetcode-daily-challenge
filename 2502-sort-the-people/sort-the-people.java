class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        int len = names.length;
        Pair arr[] = new Pair[len];
        for(int i=0; i<len; i++){
            arr[i] = new Pair(names[i], heights[i]);
        }

        Arrays.sort(arr, (a, b) -> b.h - a.h);
        // return new String[]{""};
        for(int i=0; i<len; i++){
            names[i] = arr[i].n;
        }
        return names;
    }
}

class Pair{
    String n;
    int h;
    Pair(String _n, int _h){
        n = _n;
        h = _h;
    }
}