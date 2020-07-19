class Solution {
    public String addBinary(String a, String b) {
       int i = a.length()-1;
       int j = b.length()-1;
       int carry = 0;
       StringBuilder sb = new StringBuilder();
       while (i >= 0 || j >= 0 || carry > 0) {
           int val1 = i >= 0 ? a.charAt(i)-'0' : 0;
           int val2 = j >= 0 ? b.charAt(j)-'0' : 0;
           int sum = val1 + val2 + carry;
           carry = sum / 2;
           sb.append(sum % 2);
           i--;
           j--;
       }
       return sb.reverse().toString(); 
    }
}