class Solution {
    private HashMap<String, Long> memo = new HashMap<>();
    private int MOD = 1000000007;
    public int countVowelPermutation(int n) {
        long total = 0L;
        char charSet[] = new char[]{'a', 'e', 'i', 'o', 'u'};
        for(char c : charSet){
            total = (total+helper(n-1, c)) % MOD;
        }
        return (int)total;
    }
    
    public long helper(int remaining, char prev){
        if(remaining == 0) return 1;
        Long total = 0L;
        String key = ""+ remaining + prev;
        if(memo.containsKey(key)) return memo.get(key);
        switch(prev){
            case 'a' : total = (helper(remaining - 1, 'e')) % MOD;
                break;
            case 'e' : total = (helper(remaining - 1, 'i') + 
                        helper(remaining - 1, 'a')) % MOD;
                break;
            case 'i' : total = (helper(remaining - 1, 'a') + helper(remaining - 1, 'e') + helper(remaining - 1, 'o') + helper(remaining - 1, 'u')) % MOD;  
                break;
            case 'o' : total = (helper(remaining - 1, 'i') + 
                        helper(remaining - 1, 'u')) % MOD;
                break;
            case 'u' : total = (helper(remaining - 1, 'a')) % MOD;
                break;
        }
        memo.put(key, total);
        return total;
    }
}