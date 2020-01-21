class TrieNode{
    char val;
    TrieNode[] children;
    boolean isWord;
    public TrieNode(char x){
        children = new TrieNode[26];
        isWord = false;
        val = x;
    }
}
class Trie {
private TrieNode root;
/** Initialize your data structure here. */
public Trie() {
    root = new TrieNode(' '); // '' gives wrong answer. ' ' is right.
}

/** Inserts a word into the trie. */
//time:O(M) 
//space:O(m)  

public void insert(String word) {
    TrieNode cur = root;
    for(int i = 0; i < word.length();i++){
        char c = word.charAt(i);
        if(cur.children[c-'a'] == null){
            cur.children[c-'a'] = new TrieNode(c);
        }
        cur = cur.children[c-'a'];
    }
    cur.isWord = true;
}

/** Returns if the word is in the trie. */
//time: O(m) where m is word length
//space: O(1)
public boolean search(String word) {
    TrieNode cur = root;
    for(int i = 0; i < word.length();i++){
        char c = word.charAt(i);
        if(cur.children[c-'a'] == null){
            return false;
        }
        cur = cur.children[c-'a'];
        }
    return cur.isWord; //  have to be into the last position. which is true; otherwise is false if the word is prefix word.
    }


/** Returns if there is any word in the trie that starts with the given prefix. */
//time: O(m) where the m is the prefix length;
//space: O(1)
public boolean startsWith(String prefix) {
    TrieNode cur = root;
    for(int i = 0; i < prefix.length();i++){
        char c = prefix.charAt(i);
        if(cur.children[c-'a'] == null) return false;
        cur = cur.children[c-'a'];
    }
    return true;
}
}

/**
* Your Trie object will be instantiated and called as such:
* Trie obj = new Trie();
* obj.insert(word);
* boolean param_2 = obj.search(word);
* boolean param_3 = obj.startsWith(prefix);
*/