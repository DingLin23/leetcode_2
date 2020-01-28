//time: o(n)
//space:o(n)
class Solution {
    public boolean isValid(String s) {
        //stack .. push in the oppsi char 
        //pop out to compare 
        
        //base case :true
        if(s == null || s.length() == 0) return true;
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(c == '('){
                stack.push(')');
            }
            else if(c == '['){
                stack.push(']');
            }
            else if(c == '{'){
                stack.push('}');
            }
            else{
                if(stack.isEmpty() || c != stack.pop()){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}