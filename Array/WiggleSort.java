//time:o(n)
//space:o(1)

class Solution {
    public void wiggleSort(int[] nums) {
       for(int i = 1; i<nums.length; i++){
           if((i%2==1 && nums[i]<nums[i-1]) || (i%2==0 && nums[i] > nums[i-1])){ // % 去算是even or odd 就知道是大于前面还是小于后面的数。为什么不写<= or >=因为没有必要一样就不用变了
            
               int temp = nums[i-1];
               nums[i-1] = nums[i];
               nums[i]=temp;
           }
       }
    }
}