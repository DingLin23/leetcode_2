// Time Complexity: O(2^N)
// Space Complexity: O(2^N * N)

class Solution {
    public int[] prisonAfterNDays(int[] cells, int N) {
       for (N = (N - 1) % 14 + 1; N > 0; --N) {
            int[] cells2 = new int[8];
            for (int i = 1; i < 7; ++i)
                cells2[i] = cells[i - 1] == cells[i + 1] ? 1 : 0; // u dont wanna change the value of cells[i] because u gonna use it again. u need a tmp to store that val. 
            cells = cells2;
        }
        return cells;
    }
}