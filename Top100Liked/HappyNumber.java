// time: o(logn)
//space: o(1);

class Solution {
    public boolean isHappy(int n) {
        int x = n;
        int y = n;

        // 两个指针的原理一样，一个快，一个慢，如果形成circle就说明没解，就是有两个数的sum是一样的话。 
        //一个跑得慢，一个跑得快。
        while(x>1){
            x = cal(x) ;
            if(x==1) return true ;
            y = cal(cal(y));
            if(y==1) return true ;

            if(x==y) return false;
        }
        return true ;
    }
    public int cal(int x){
        int s = 0;
        while(x>0){// 如果出现 x/10等于0 跳出while loop
            s += (x%10)*(x%10);
            x /= 10;
        }
        return s ;
    }
}