//time: o(n)
//space:o(1)

class Solution {
    public int findUnsortedSubarray(int[] nums) {
    int n = nums.length, beg = -1, end = -2, min = nums[n-1], max = nums[0];
    for (int i=1;i<n;i++) {
      max = Math.max(max, nums[i]); //  检查如果是升序，就update大的数
      min = Math.min(min, nums[n-1-i]);// 如果是从后往前减小的，就update 小的。
      if (nums[i] < max) {
          end = i; //end 走到最右
          System.out.print(end + "e" + " ");
      }
      if (nums[n-1-i] > min) {
          beg = n-1-i; // beg 往左。
          System.out.print(" "+beg + "b");
      }
    }
    return end - beg + 1;
    }
}