//time:o(lgn)
//space:o(1)
class Solution {
    public int hIndex(int[] citations) {
        int len = citations.length;
        if (citations.length == 0 || citations == null) return 0;
        int left = 0, right = len-1;
        while (left+1 < right) {
            int mid = left + (right-left)/2;
            if (citations[mid] == len - mid) {
                return len-mid;
            }
            else if (citations[mid] > len-mid) {
                right = mid;
            }else {
                left = mid;
            }
        }
        
        if (citations[left] >= len-left)  return len-left;
        if (citations[right] >= len-right)  return len-right;
        return 0;
    }
}