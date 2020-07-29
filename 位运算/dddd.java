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
    for (int i = 0; i < nums.length; i++) {
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

public static int droppedRequests(List<Integer> requestTime) {
    int request = 0, res = 0;
    int left = 0, right = requestTime.size()-1;
    while (left < right) {
       while (requestTime.get(left) == 1 && left < requestTime.size()) {
           left++;
           request++;
           if (request > 3) {
               res++;
           }
       }
       while (requestTime.get(left) < 10 && left < requestTime.size()) {
           left++;
           request++;
           if (request > 20) {
               res++;
           }
       }
       while (requestTime.get(left) < 60 && left < requestTime.size()) {
        left++;
        request++;
        if (request > 60) {
            res++;
        }
        }
    }
    return res;
    }
}