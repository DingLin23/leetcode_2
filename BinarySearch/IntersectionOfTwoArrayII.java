//time : o(n+m)
//space : o(min(n,m))

class Solution {
    public int[] intersect(int[] A, int[] B) {
    if (A.length == 0 || B.length == 0) return new int[0];
    if (A.length > B.length) return intersect(B, A);  // apply bs on bigger array
    List<Integer> list = new ArrayList<>();
    Arrays.sort(A);
    Arrays.sort(B);
    
    int lowerBound = 0;  // lower bound for binary search
    for (int i = 0; i < A.length; i++) {
        int index = binarySearch(B, lowerBound, A[i]);
        if (index < B.length && B[index] == A[i]) {  // found on B
            list.add(A[i]);
            lowerBound = index + 1;
        }
    }

    // adding result from list to final int[]
    int[] res = new int[list.size()];
    int i = 0;
    for (int n : list)  res[i++] = n;
    return res;
}

private int binarySearch(int[] A, int lo, int target) {
    int L = lo, R = A.length-1;
    while (L < R) {
        int M = L + (R - L) / 2;
        if (A[M] < target)  L = M + 1;
        else                R = M;
    }
    return L;
}
}

//time : O(nlgm)
//space :o(n)
class Solution {

 public int[] intersect(int[] nums1, int[] nums2) {
        // freq count for nums1
        HashMap<Integer, Integer> map = new HashMap();
        for (int num : nums1) map.put(num, map.getOrDefault(num, 0) + 1);
        // collect result
        ArrayList<Integer> result = new ArrayList();
        for (int num: nums2) {
            if (map.containsKey(num)){
                result.add(num);
                map.put(num, map.get(num) - 1);
                map.remove(num, 0);
            }
        }
       // convert result
       int[] r = new int[result.size()];
       for(int i = 0; i < result.size(); i++) {
           r[i] = result.get(i);
       }
       return r;
    }
}


//time :O(nlgn + mlgm)
//space: o(1)

class Solution {
public int[] intersect(int[] nums1, int[] nums2) {
    Arrays.sort(nums1);
    Arrays.sort(nums2);
    int i = 0, j = 0, k = 0;
    while (i < nums1.length && j < nums2.length) {
        if (nums1[i] < nums2[j]) {
            ++i;
        } else if (nums1[i] > nums2[j]) {
            ++j;
        } else {
            nums1[k++] = nums1[i++];
            ++j;
        }
    }
    return Arrays.copyOfRange(nums1, 0, k);
}
}