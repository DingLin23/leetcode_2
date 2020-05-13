//time:o(n)
//space:o(1)
public class ReverseInteger {
    //扩大
    public int reverse(int x){
        long res = 0;
        while (x != 0) {
            res = res * 10 + x % 10;
            x /= 10;
            if(res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
                return 0;
            }
        }
        return (int) res;
    }

    //比较
    public int reverse2(int y){
        int res = 0;
        while(y != 0) {
            int cur = res;
            res = res * 10 + y % 10;
            if(cur != res/10) return 0;
            x /= 10;
        }
        return res;
    }
    
}