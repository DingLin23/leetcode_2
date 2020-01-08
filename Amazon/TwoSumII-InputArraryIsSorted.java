//time:0(n)
//space:O(1)

//since is sorted two pointer saves mermory, we dont use hashmap.
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length-1;
        while(left < right){
            int sum = numbers[left] + numbers[right];
            if(sum < target){
                left++;
            }
            else if(sum > target){
                right--;
            }else{
                return new int[]{left+1,right+1};
            }
        }
        throw new IllegalArgumentException();
    }
}