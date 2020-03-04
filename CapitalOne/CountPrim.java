//time:o(nlglgn)
//space:o(n)

class Solution {
    public int countPrimes(int n) {
        boolean[] notPrime = new boolean[n];
        int res = 0;
        //prime number start from 2.
        for (int i = 2; i < n; i++) {
            if (notPrime[i] == false) { // start from 2 is always prime
                res++;
                for (int j = 2; i * j < n; j++) { // checking any mutiplication with 2 , which mark as true notPrime. 
                    notPrime[i * j] = true;
                }
                // backing to check when i = 3; until finish the one lease  1 than n.
            }
        }
        return res;
    }
}