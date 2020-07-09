import jdk.vm.ci.meta.Assumptions.LeafType;

public class BalanceArray {
    public int balanceArray(int[]arr) {
        int sum = 0, left_sum = 0;
        for (int a : arr) {
            sum += a;
        }
        for (int i = 0; i < arr.length; i++) {
            if (left_sum == sum - left_sum - arr[i]) {
                return i;
            }
            left_sum += arr[i];
        }
        return -1;
    }
    
}