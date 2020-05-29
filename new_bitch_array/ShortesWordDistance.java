//time: o(n^2)
//space: o(1)
class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int res = words.length;
        for (int i = 0; i < words.length; i++) { 
            if (words[i].equals(word1)) {
                for (int j = 0; j < words.length; j++) {
                    if (words[j].equlas(word2)) {
                        res = Math.min(res, Math.abs(i-j));
                    }
                }
            }
        }
        return res;
    }
}

//time: o(n)
//space: o(1)
class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int res = words.length;
        int a = -1;
        int b = -1;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                a = i;
            }
            else if (words[i].equals(word2)) {
                b = i;
            }
            if(a != -1  && b != -1) {
                res = Math.min(res, Math.abs(a-b));
            }
        }
        return res;
    }
}