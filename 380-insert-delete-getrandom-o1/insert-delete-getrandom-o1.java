public class RandomizedSet {
    ArrayList<Integer> nums;
    HashMap<Integer, Integer> locs;
    java.util.Random rand = new java.util.Random();
    /** Initialize your data structure here. */
    public RandomizedSet() {
        nums = new ArrayList<Integer>();
        locs = new HashMap<Integer, Integer>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        boolean contain = locs.containsKey(val);
        if ( contain ) return false;
        locs.put( val, nums.size());
        nums.add(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        boolean contain = locs.containsKey(val);
        if ( ! contain ) return false;
        int loc = locs.get(val);
        if (loc < nums.size() - 1 ) { // not the last one than swap the last one with this val
            int lastone = nums.get(nums.size() - 1 );
            nums.set( loc , lastone );
            locs.put(lastone, loc);
        }
        locs.remove(val);
        nums.remove(nums.size() - 1);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return nums.get( rand.nextInt(nums.size()) );
    }
}


/*

class RandomizedSet {
    HashMap<Integer, Integer> map;
    ArrayList<Integer> list;
    int idx = 0;
    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }
    
    public boolean insert(int val) {
        Integer num = map.get(val);
        if(num == null){
            list.add(val);
            map.put(val, idx);
            idx++;
        }else{
            return false;
        }
        
        return true;
    }
    
    public boolean remove(int val) {
        
        Integer num = map.get(val);
        if(num == null){
            return false;
        }else{
            if(list.size() == 1){
                int number = list.get(0);
                map.remove(number);
                list.remove(0);
                return true;
            }
            swap(list, num, idx-1);
            int delete = list.get(idx-1);
            map.remove(delete);
            map.put(list.get(num), num);
            list.remove(idx-1);
            idx--;
        }
        return true;
    }
    
    public int getRandom() {
        Random random = new Random();
        int n = random.nextInt(list.size());
        return list.get(n);
    }
    
    void swap(ArrayList<Integer> list, int idx1, int idx2){
        int num = list.get(idx1);
        list.set(idx1, list.get(idx2));
        list.set(idx2, num);
    }
}

*/

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */