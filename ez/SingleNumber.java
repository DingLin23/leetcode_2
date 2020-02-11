// we use bitwise XOR to solve this problem :
// Bitwise XOR (exclusive or) "^" is an operator in Java that provides the answer '1' 
// if both of the bits in its operands are different, 
// if both of the bits are same then the XOR operator gives the result '0'. 
// first , we have to know the bitwise XOR in java

// 0 ^ N = N
// N ^ N = 0
// So..... if N is the single number

// N1 ^ N1 ^ N2 ^ N2 ^..............^ Nx ^ Nx ^ N

// = (N1^N1) ^ (N2^N2) ^..............^ (Nx^Nx) ^ N

// = 0 ^ 0 ^ ..........^ 0 ^ N

// = N
// time:o( n)
//space:o(1)
class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for(int i = 0; i < nums.length; i++){
            ans ^= nums[i];
        }
        return ans;
    }
}