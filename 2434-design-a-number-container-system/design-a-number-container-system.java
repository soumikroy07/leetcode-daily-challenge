
class NumberContainers {

    /*
    Map<Integer, PriorityQueue<Integer>> vi = new HashMap<>();
    Map<Integer, Integer> iv = new HashMap<>();
    public NumberContainers() {
        
    }
    
    public void change(int index, int number) {
        if(iv.containsKey(index)){
            int prev = iv.get(index);
            PriorityQueue<Integer> pq = vi.get(prev);
            pq.remove(index);
            if(pq.size() == 0){
                vi.remove(prev);
            }
            iv.remove(index);
        }

        iv.put(index, number);
        if(vi.containsKey(number)){
            PriorityQueue<Integer> pq = vi.get(number);
            pq.add(index);
        }else{
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            pq.add(index);
            vi.put(number, pq);
        }

    }
    
    public int find(int number) {
        if(vi.containsKey(number)){
            return vi.get(number).peek();
        }else{
            return -1;
        }
    }

    
*/
    private Map<Integer, TreeSet<Integer>> numToIndices = new HashMap<>();
    private Map<Integer, Integer> indexToNum = new HashMap<>();

    public NumberContainers() {}
    
    public void change(int index, int number) {
        if (indexToNum.containsKey(index)) {
            int old = indexToNum.get(index);
            numToIndices.get(old).remove(index);
            if (numToIndices.get(old).isEmpty()) {
                numToIndices.remove(old);
            }
        }
        indexToNum.put(index, number);
        numToIndices.computeIfAbsent(number, s -> new TreeSet<>()).add(index);
    }
    
    public int find(int number) {
        if (numToIndices.containsKey(number)) {
            return numToIndices.get(number).first();
        }
        return -1;
    }
}


    

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */