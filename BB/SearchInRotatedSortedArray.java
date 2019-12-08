class Solution {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1;
        int left = 0;
        int right = nums.length -1;
        
        while(left < right){
            int mid = left + (right - left)/2;
            if(nums[mid] > nums[right]){
                left = mid+1;
            }else{
                right = mid;   // finding the pivot. 
            }
        }
        
        int start = left; // recording the pivot
        right = nums.length-1;//reiniting right
        left = 0;
        if(target >= nums[start] && target <= nums[right]){ //find the target in which half
            left = start;
        }else{
            right = start-1;
        }
        
        while(left <= right){ // regular BST.
            int mid = left + (right-left)/2;
            if(nums[mid] == target) return mid;
            else if(nums[mid] < target) left = mid+1;
            else right = mid-1;
        }
        return -1;
    }
}