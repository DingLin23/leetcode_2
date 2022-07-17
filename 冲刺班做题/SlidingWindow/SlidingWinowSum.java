import javax.swing.WindowConstants;

public class SlidingWinowSum {
    //A[1,2,3,4]  return [1,3,6,10]
    // step1: HightLevel: fixed size sliding window sum query problem
    //         for every possible ending index: fast
    //             we want to know the sum from [fast-k+1,fast]
    
    // step2: Detail logic:
    //     [a,b,c] d
    //             fast
    //         step1: add fast
    //             window1 + array[fast]
    //         step2: remove slow
    //                 when your Window size > k
    //                 window1 - array[fast-k]
    //         step3: update Solution
    //                 when your window size == k 
    // 1 2 3 4 5
    // 0 1 2 3 4   k = 3 fast = 3
    // time: o(n)
    public List<Integer> SlidingWinowSum(int[] a, int k) {
        List<Integer> res = new ArrayList<>();
        if (a == null || a.length == 0) return res;

        int windowSum = 0;
        for (int fast = 0; fast < a.length; fast++) {
            //add fast
            windowSum += a[fast];
            if (fast >= k) {
                windowSum -= a[fast-k];
            }
            if (fast >= k-1) {
                res.add(windowSum);
            }
        }
        return res;
    }
    
}
