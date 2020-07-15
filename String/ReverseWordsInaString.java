//time:o(n)
//space:o(n)

class Solution {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) return s;
        StringBuilder sb = new StringBuilder();
        String[] words = s.trim().split("\\s+"); //  \\s+ means one or more whitespace.
        for (int i = words.length - 1; i >=0; i--) {
            sb.append(words[i] + " ");
        }
        return sb.toString().trim();  // trim 去掉最尾部加的whitespace；
    }
}