class Solution {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length-1; i >= 0; i--) {
            if (digits[i] == 9) digits[i] = 0;
            else {digits[i]++; // find the one is not 9 which we can output the solution
                return digits;
                 }
        }
        digits = new int[digits.length+1]; // case of all 9;
        digits[0] = 1;//case of all 9 need to set top as 1;
        return digits;
    }
}
