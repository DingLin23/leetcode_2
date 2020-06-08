//time:O(logn)
//space:O(1)

class Solution {
    public boolean isPowerOfTwo(int n) {
         if (n <= 0) return false;
            while (n%2 == 0) n/=2;
            return n == 1;
    }
}

//time:O(1)
//space:O(1)

class Solution {
    public boolean isPowerOfTwo(int n) {
         if(n > 0 && ((n&(n-1)) == 0)) return true;
        return false;
    }
}