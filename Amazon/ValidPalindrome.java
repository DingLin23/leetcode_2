//time:O(n)
//space:O(1)
class Solution{
    public boolean isPalindrome(String s){
        if(s == null || s.length()==0) return true;
        int left = 0, right = s.length()-1;
        while(left < right){
        while(left < right && !Character.isLetterOrDigit(s.charAt(left))){
            left++;  //去排掉空格或者不是数字和letter的符号之类。 %&！！！  a@aaa@. 排完得到a@aaa@
        }
        while(left < right && !Character.isLetterOrDigit(s.charAt(right))){
            right--; // 排完得到a@aaa@
        }
        if(Character.toLowerCase(left)!= Character.toLowerCase(right)){
            return false;
        }
        left++;
        right--;
    }
    return true;
    }
        

}