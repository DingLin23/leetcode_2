// Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

// An input string is valid if:

// Open brackets must be closed by the same type of brackets.
// Open brackets must be closed in the correct order.
// Note that an empty string is also considered valid.

// Example 1:

// Input: "()"
// Output: true
// Example 2:

// Input: "()[]{}"
// Output: true
// Example 3:

// Input: "(]"
// Output: false
//time:o(n)
//spcae:o(n)
class Solution {
    public boolean isValid(String s) {
        //stack .. push in the oppsi char 
        //pop out to compare 
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
                if(stack.isEmpty() || c != stack.pop()){ //如果是（），{} 是这种情况这里可以排查。（【】）也是可以的，因为stack last in first out 的原理
                    return false;
                }
            }
        }
        return stack.isEmpty(); // return stack.isEmpty（）就好了，因为说明stack里已经排查完。
    }
}