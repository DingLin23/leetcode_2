//time: o(nlgn)
//space: o(1)
// If the dist to B is much longer than the dist to A, now the dif of dist to A and B could be very small and < 0. Therefore, we should assign these interviewees to A instead of B.
// So we sort the array by the difference of dist in ascending order and the first half are the interviewees assigned to A.
class Solution{
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, (a,b) -> {
            return (a[0]-a[1]) - (b[0]-b[1]);
        });

        int res = 0;
        for(int i = 0; i < costs.length; i++){
            if(i < costs.length/2){
                res += costs[i][0];
            }else{
                res += costs[i][1];
            }
        }
        return res;
    }
}