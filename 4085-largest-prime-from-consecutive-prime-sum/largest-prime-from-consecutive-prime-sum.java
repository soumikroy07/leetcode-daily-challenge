class Solution {
    public int largestPrime(int n) {
        // List<Integer> primes = getPrimes(n);
        boolean isPrime[] = getPrimes(n);

        List<Integer> primes = new ArrayList<>();
        for(int i=2; i<=n; i++){
            if(!isPrime[i]){
                primes.add(i);
            }
        }

        int sum = 0, ans = 0;
        for(int prime: primes){
            sum += prime;
            if(sum > n){
                break;
            }
            if(!isPrime[sum]){
                ans = Math.max(ans, sum);
            }
        }

        return ans;
    }

    boolean[] getPrimes(int n){
        boolean prime[] = new boolean[n+1];
        for(int i=2; i<=n; i++){
            if(!prime[i]){
                for(int j=2*i; j<=n; j+=i){
                    prime[j] = true;
                }
            }
        }

        
        return prime;
    }
}