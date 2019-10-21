//time:o(n)
//space:o(1)

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if(gas.length == 0 || cost.length == 0 || gas.length != cost.length) return -1;
        for(int i = 0; i < gas.length; i++){
            total += gas[i] - cost[i]; // 数学定理，如果总和是负数是肯定没法走回原点。
            if(sum < 0){
                sum = gas[i]-cost[i];//新的和
                start = i;//记录新的起始点
            }
            else{
                sum += gas[i]-cost[i]; //如果当前不为负数，就继续走
            }

        }
        return total <0 ? : start;
    }
}