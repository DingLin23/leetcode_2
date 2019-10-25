//time:o(n)
//space:o(n)

class Solution {
    public String simplifyPath(String path) {
        //corner cases
        if(path == null || path.length()==0) return "";
        path.trim();
        Stack<String> stack = new Stack<>();
        String[] s = path.split("/");
            for(int i=0; i< s.length;i++){
                if(!stack.isEmpty() && s[i].equals("..")){
                    stack.pop();
                }
                else if(!s[i].equals(".") && !s[i].equals("..") && !s[i].equals("")){
                    stack.push(s[i]);
                }
            }
        List<String> list = new ArrayList<>(stack);
        return "/" + String.join("/",list);
    }
}

// . stay 
// .. go up dir
// 