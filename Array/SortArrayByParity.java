//time:o(n)
//space:(1)
//用两个指针去做临时存储
class Solution {
    public int[] sortArrayByParity(int[] A) {
        for (int i = 0, j = 0; j < A.length; j++)
            if (A[j] % 2 == 0) {
                int tmp = A[i];
                A[i++] = A[j];
                A[j] = tmp;;
            }
        return A;
    }
}