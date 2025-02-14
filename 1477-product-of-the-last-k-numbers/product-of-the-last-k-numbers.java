class ProductOfNumbers {
    /*
     * 
     * List<Integer> list;
     * int lastZero = -1;
     * public ProductOfNumbers() {
     * list = new ArrayList<>();
     * }
     * 
     * public void add(int num) {
     * if(list.size() == 0){
     * list.add(num);
     * }
     * if(num == 0){
     * lastZero = list.size();
     * }
     * 
     * if(list.get(list.size() - 1) != 0){
     * list.add(list.get(list.size() - 1) * num);
     * }else{
     * list.add(num);
     * }
     * }
     * 
     * public int getProduct(int k) {
     * int n = list.size();
     * if(lastZero >= n - k){
     * return 0;
     * }
     * else if(list.get(n - k - 1) == 0){
     * return list.get(n-1);
     * }else{
     * return list.get(n-1) / list.get(n - k - 1);
     * }
     * }
     */

    ArrayList<Integer> A = new ArrayList() {
        {
            add(1);
        }
    };

    public void add(int a) {
        if (a > 0)
            A.add(A.get(A.size() - 1) * a);
        else {
            A = new ArrayList();
            A.add(1);
        }
    }

    public int getProduct(int k) {
        int n = A.size();
        return k < n ? A.get(n - 1) / A.get(n - k - 1) : 0;
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */