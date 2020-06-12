//time: o(n)
//space:o(1)

class Solution {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int count1 = 0, count2 = 0, count0 =0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) count0++;
            else if (nums[i] == 1) count1++;
            else count2++;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (i < count0) {
                nums[i] = 0;
            }
            else if (i < count0+count1) {
                nums[i] = 1;
            }
            else {
                nums[i] = 2;
            }
        }
    }


    //one pass
public void sortColors1(int[] nums) {
    // for all idx < i : nums[idx < i] = 0
    // j is an index of element under consideration
    int p0 = 0, curr = 0;
    // for all idx > k : nums[idx > k] = 2
    int p2 = nums.length - 1;

    int tmp;
    while (curr <= p2) {
      if (nums[curr] == 0) {
        // swap p0-th and curr-th elements
        // i++ and j++
        tmp = nums[p0];
        nums[p0++] = nums[curr];
        nums[curr++] = tmp;
      }
      else if (nums[curr] == 2) {
        // swap k-th and curr-th elements
        // p2--
        tmp = nums[curr];
        nums[curr] = nums[p2];
        nums[p2--] = tmp;
      }
      else curr++;
    
    }
    }
}