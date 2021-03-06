class Solution {
    public int minSwaps(int[] nums) {
        if(nums.length < 3) return 0;
        int n = 0;
        for(int num: nums){
            if(num == 1) n++; // total number of 1s
        }
        int i=0, j=0, c=0, max=0; //sliding window i to j
        while(j < nums.length) {
            while(j < nums.length && j - i < n){ //until i to j == n or search is done
                if(nums[j++] == 1) c++;
            }
            max = Math.max(c, max); // max all the sliding window of which length equals to n
            if(j == nums.length) break; // if not this line when j == nums.length,
            //the next line i++ checking out of bounce.
            
            if(nums[i++] == 1) { //move i forward
                c--;
            }
        }
        return n - max; //this is the minimun swaps  
    }
}