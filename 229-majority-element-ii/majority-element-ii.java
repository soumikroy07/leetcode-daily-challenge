class Solution {
    public List<Integer> majorityElement(int[] a) {
//         HashMap<Integer , Integer> map = new HashMap<>();
//         for (int i : nums){
//             if(map.containsKey(i)){
//                 map.put(i, map.get(i)+1);
//             }else{
//                 map.put(i,1);
//             }
//         }
        
        ArrayList<Integer> ans = new ArrayList<>();
//         for(Map.Entry<Integer , Integer> m : map.entrySet()){
//             if(m.getValue() > nums.length/3){
                
//                 ans.add(m.getKey());
//             }
//         }
//         return ans;
        
        int val1 = a[0];
        int count1 = 1;
        
        int val2 = a[0],count2 = 0;
        
        for(int i=1; i<a.length; i++){
            if(val1 == a[i]){
                count1++;
            }else if(val2 == a[i]){
                count2++;
            }else{
                if(count1 == 0){
                    count1 = 1;
                    val1 = a[i];
                }else if(count2 == 0){
                    val2 = a[i];
                    count2 = 1;
                }else{
                    count1--;
                    count2--;
                }
            }
        }
        
        if(moreThanN3(a,val1)){
            ans.add(val1);
        }
            if(moreThanN3(a,val2) && val1 != val2){
            ans.add(val2);
        }
        return ans;
    }
    
    public boolean moreThanN3(int a[], int n){
        int count = 0;
        for(int i : a){
            if(i == n) count++;
        }
        if(count > a.length/3){
            return true;
        }
        return false;
    }
}