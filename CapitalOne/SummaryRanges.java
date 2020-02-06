// time: O(n)
//space:o(1)

class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> list=new ArrayList();
        if(nums == null || nums.length == 0) return list;
        for(int i=0;i<nums.length;i++){
    	    int a=nums[i]; // pointer has been update when i is not continous at some index.
    	    while(i+1<nums.length&&(nums[i+1]-nums[i])==1){ // while true pointer keep going 
    		    i++;
    	    }
    	    if(a!=nums[i]){ // if not matching it mean we end of the continous 
    		    list.add(a+"->"+nums[i]);
    	    }else{ // case of  iso
    		    list.add(a+"");
    	    }
        }
        return list;
    }
}