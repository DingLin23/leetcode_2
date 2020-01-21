class Solution{
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
            List<List<String>> res = new ArrayList<>();
            Set<String> dict = new HashSet<>(wordList);
            
            //BASE CASE
            if (!dict.contains(endWord)) return res;
            
            Map<String, List<String>> map = new HashMap<>();
            Set<String> startSet = new HashSet<>();
            startSet.add(beginWord);
            bfs(startSet, endWord, map, dict);
    
            List<String> list = new ArrayList<>();
            list.add(beginWord); // carrring beginWord.
            dfs(res, list, beginWord, endWord, map);
            return res;
            
        
        }
    
    
        private void dfs(List<List<String>> res, List<String> list, String beginWord, String endWord, Map<String, List<String>> map) {
            if (beginWord.equals(endWord)) { //如果beginword == endword return [], 如果找到一个答案，开一个list。
                res.add(new ArrayList(list));
                return;
            }
    
            if (map.get(beginWord) == null) return; //如果没有能转换的。
            for (String next : map.get(beginWord)) {
                list.add(next);
                dfs(res, list, next, endWord, map);
                list.remove(list.size() - 1);
            }
        }
    
        private void bfs(Set<String> startSet, String endWord, Map<String, List<String>> map, Set<String> dict) {
            if (startSet.size() == 0) return; // get rid of this line will cause stack over flow, can not get rid of the bfs;
    
            Set<String> tmp = new HashSet<>();
            dict.removeAll(startSet);//还有就是把已经找到的转换删掉。
            // System.out.print(dict);
            boolean finish = false;
    
            
            for (String s : startSet) { //作用就是只要还在这个for l
                char[] chs = s.toCharArray();
                for (int i = 0; i < chs.length; i++) {
                    char old = chs[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        chs[i] = c;
                        String word = new String(chs);
    
                        if (dict.contains(word)) {
                            
                            if (word.equals(endWord)) {
                                finish = true; // 找到答案，就不循环bfs，结束了。
                            } else {
                                tmp.add(word); // tmp去加之前没找到的答案前的转变的的word.
                                 // System.out.print(tmp + "T");
                            }
    
                            if (map.get(s) == null) { // 如果这个map在s这个位置value是空的
                                //System.out.println(map.get(s));
                                map.put(s, new ArrayList<>());
                               
                            }
    
                            map.get(s).add(word);
                             // System.out.print(map + "--");
                        }
                    }
    
                    chs[i] = old;// 如果首字母转换没找到，我们往下查找下一个，要变回原来的首字母。
                }
            }
    
            if (!finish) { // 如果还没找到endword，继续bfs. 
                bfs(tmp, endWord, map, dict); //tmp 变成新的startSet.
            }
        }
    }