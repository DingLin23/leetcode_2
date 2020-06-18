//Time: O(lgn)
//space: o(1)

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = -1;
        res[1] = -1;
        
        if(nums == null || nums.length == 0) return res;
        
        res[0] = findFirst(nums,target);
        res[1] = findLast(nums,target);
        return res;
           
    }
    private int findFirst(int[] nums, int target){
        int start = 0, end = nums.length -1;
   
        while(start+1 < end){
                 int mid = start + (end-start)/2;
            if(nums[mid] >= target){
                end = mid;
            }else{
                start = mid;
            }
        }
        if(nums[start] == target) return start;
        else if(nums[end] == target) return end;
        return -1;
    }
    private int findLast(int [] nums, int target){
        int start = 0, end = nums.length -1;
   
        while(start+1<end){
                 int mid = start + (end-start)/2;
            if(nums[mid] <= target){
                start = mid;
            }else{
                end = mid;
            }
        }

        if(nums[end] == target) return end;
        else if(nums[start] == target) return start;
        return -1;
    }
}


