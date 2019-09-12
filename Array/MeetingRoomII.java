import java.util.Arrays;

// time:o(nlgn)
//space:o(n)

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];
        for(int i=0; i<intervals.length; i++) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        int res = 0;
        int end = 0;
        for(int i=0; i<starts.length; i++) {
            if(starts[i]<ends[end])
                res++;
            else
                end++;
        }
        return res;
        
    }
}