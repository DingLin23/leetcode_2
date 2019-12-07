//time:O(Nlgn)
//space:O(1)
class Solution {
    public int lastRemaining(int n) {
        boolean flag = true;
        int head = 1;
        int step = 1;
        while(n >1){
            if(flag || n % 2 ==1){//only first time need to update head we need boolean flag here;
                //following by pattern true,false,true,false;always update head when in odd iteration.everytime after we cut remaining into half;
                head += step; // first case head always +1;
            }
            step *= 2;
            flag = !flag; 
            n /= 2; //special case when n = 2 will be dealed in here;
        }
        return head;
    }
}