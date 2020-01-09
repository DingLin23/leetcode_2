//time:o(n)
//space:o(1)

//work for unsorted arr.
class Solution {
    public int missingNumber(int[] arr) {
        int first = arr[0], last = arr[0], sum = 0, n = arr.length;
        for (int a : arr) {
            first = Math.min(first, a);
            last = Math.max(last, a);
            sum += a;
        }
        return (first + last) * (n+1) / 2 - sum; // n+1 because missing one
        
    }
}