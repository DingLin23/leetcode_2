//time:O(n)
//space:O(n)
import java.util.*;
public class TwoSum{
public static int[] Ts(int[] nums, final int target){
    int [] res = new int[2];
    if(nums == null || nums.length < 2) return res;
    Map<Integer,Integer> map = new HashMap<>();
    for(int i = 0; i < nums.length; i++){
        if(map.containsKey(target - nums[i])){
            res[0] = map.get(target-nums[i]);
            res[1] = i;
        }
        map.put(nums[i],i);
    }
    return res;
}

    public static void main(String[] args) {
        int nums[] = { 1, 4, 6, 3 };
        int target = 7;
        int res []=Ts(nums, target);
        System.out.println(res);
}
}