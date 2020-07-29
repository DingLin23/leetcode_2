class Solution {
public static int droppedRequests(List<Integer> requestTime) {
    int []drop = new int[requestTime.size()];
    int [] nums = new int[requestTime.size()];
    for (int i = 0; i < requestTime.size();i++) {
        nums[i] = requestTime.get(i);
    }
    helper(nums,drop,1,3);
    helper(nums,drop,10,20);
    helper(nums,drop,60,60);
    int count = 0;
    for (int i = 0; i < n; i++) {
        count+= drop[i];
    }
    return count;
}

private static void helper(int[]nums,int[]drop,int time, int limit) {
    for (int i = 0; i < nums.length; i++) {
        int tmp = i;
        int startTime =  nums[i];
        int count = 0;
        while (i < nums.length && nums[i] <= startTime + time -1 && count < limit) {
            i++;
            count++;
        }
        while (i < nums.length && nums[i] <= startTime + time -1) {
            drop[i++] =1;
        }
        i = tmp;
    }
}
}