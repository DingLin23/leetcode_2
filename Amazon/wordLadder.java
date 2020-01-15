// Time Complexity: O(N*K^2) , where N is the length of words and K is the maximum length of any given word. For each word in words, in order to find neighbors we may construct O(K) new words, each in O(K) time.

// Space Complexity: O(NK), the space to store the word list.

class Solution {
    //counts transformations times.
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int level = 0;
        while(!queue.isEmpty()){
            int size = queue.size();// must to have this, becasue queue.size()will change, we need to record size for that time.
            for(int i = 0; i < size; i++){
                String cur = queue.remove();
                char[] wordUnit = cur.toCharArray();
                if(cur.equals(endWord)){
                    return level+1;
                }
                for(int j = 0; j < cur.length();j++){
                    char temp = wordUnit[j];//store the original wordUnit.
                    for(char c ='a'; c<='z';c++){
                        wordUnit[j] = c;
                        String s = new String(wordUnit);
                        if(set.contains(s)){
                            queue.add(s);
                            set.remove(s);
                        }
                    }
                    wordUnit[j] = temp;//if the first letter changes not found, get back to the original wordUnit.
                }
            }
            level++;
        }
        return 0;
    }
}



