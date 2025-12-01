class RandomizedSet {
    List<Integer> list;
    Map<Integer, Integer> map;

    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        } else {
            list.add(val);
            map.put(val, list.size() - 1);
        }
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int rIndex = map.get(val);
        int temp = list.get(rIndex);

        Collections.swap(list, rIndex, list.size() - 1);
        map.put(list.get(rIndex), rIndex);
        map.remove(val);
        list.remove(list.size() - 1);

        return true;
    }

    public int getRandom() {
        int min = 0;
        int max = list.size()-1;
        int randomNumber = (int) (Math.random() * (max - min + 1)) + min; // Generates a number between 50 and 100 (inclusive)
        return list.get(randomNumber);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */