class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int res = words.length;
        for (int i = 0; i < words.length; i++) { 
            if (words[i].equals(word1)){
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