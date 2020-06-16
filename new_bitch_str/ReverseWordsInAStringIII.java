//time:o(n) length of string
//space: o(n) res of size n is used;

class Solution {
    public String reverseWords(String s) {
       StringBuilder res = new StringBuilder();
        String[] arr = s.split(" ");
        for (String str: arr) {
            StringBuilder sb = new StringBuilder(str);
            sb.reverse();
            res.append(sb.toString());
            res.append(" ");
        }
        return res.toString().trim();
    }
    // String words[] = s.split(" ");
    //     StringBuilder res=new StringBuilder();
    //     for (String word: words)
    //         res.append(new StringBuffer(word).reverse().toString() + " ");
    //     return res.toString().trim();
}