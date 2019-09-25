//time: o(lgn)
//space:o(1)

class Solution{
    public int [] searchRange(int []nums, int target){
        int[] res = new int[2];
        res[0] = -1;
        res[1] = -1;
        if(nums == null || nums.length== 0) return res;

        //花开两朵，各表一只。
        res[0] = findFirst(nums,target);
        res[1] = findLast(nums, target);

        //返回
        return res;

    }
    //binary search的方法实现两朵花。
    private int findFirst(int[] nums, int target){//第一个target出现的位置。【5，7，7，8，8，10】
        int start = 0, end = nums.length-1;
        while(start+1<end){
            int mid = start + (end - start)/2;
            //为什么不直接用（start+end）/2的方法求mid？
            if(nums[mid] >= target){
                end = mid;
            }else{
                start = mid;
            }
        }
        if(nums[start]==target) return start;//尽可能取到小的那个index
        else if(nums[end]==target) return end;

        return -1;
    }
    private int findLast(int[] nums, int target){//第二个target出现的位置。【5，7，7，8，8，10】
        int start = 0, end = nums.length-1;
        while(start+1<end){
            int mid = start + (end - start)/2;
            //为什么不直接用（start+end）/2的方法求mid？
            if(nums[mid] <= target){
                start = mid;
            }else{
                end = mid;
            }
        }
        if(nums[end]==target) return end;//尽可能取到大的那个index
        else if(nums[start]==target) return start;

        return -1;
    }
}
//1. sorted  + ascending order
//2. runtime complexity O(lg n)
// = binary search
// first+last position 花开两朵，各表一只。
// target 是否存在array里。