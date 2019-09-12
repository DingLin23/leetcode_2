import java.util.Arrays;

//time:o(nlgn)

//space:o(1);
class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        if (intervals == null)
            return false;
        Arrays.sort(intervals, (int[] a, int[] b) -> (a[0]-b[0]));
        for(int i=1; i<intervals.length; i++)
            if(intervals[i][0]<intervals[i-1][1]) return false;
        return true;
    }

}

