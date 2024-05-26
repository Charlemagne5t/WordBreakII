import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Trie trie = new Trie();
        for(String w : wordDict) {
            trie.insert(w);
        }

        List<String> res = new ArrayList<>();
        dfs(trie, s, 0, "", "", res);
        return res;

    }

    void dfs(Trie trie, String s, int i, String curString, String curWord,  List<String> res) {
        if(i == s.length()) {
            if(curWord.length() == 0)  {
                res.add(curString);
            }
            return;
        }

        curWord += s.charAt(i);
        dfs(trie, s, i + 1, curString, curWord, res);
        if(trie.search(curWord)) {
            if(curString.length() != 0){
                curString += " ";
            }
            curString += curWord;
            dfs(trie, s, i + 1, curString, "", res);
        }


    }
}
class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode('0');
    }

    public void insert(String word) {
        int wordLength = word.length();
        TrieNode temp = root;
        for (int i = 0; i < wordLength; i++) {
            if(!temp.children.containsKey(word.charAt(i))){
                TrieNode node = new TrieNode(word.charAt(i));
                temp.children.put(word.charAt(i), node);
            }
            temp = temp.children.get(word.charAt(i));
            if(i == wordLength - 1){
                temp.isTerminal = true;
            }
        }

    }

    public boolean search(String word) {
        TrieNode temp = root;
        for (int i = 0; i < word.length(); i++) {
            if(temp.children.containsKey(word.charAt(i))){
                temp = temp.children.get(word.charAt(i));
            }else return false;
        }
        return temp.isTerminal;
    }

    public boolean startsWith(String prefix) {
        TrieNode temp = root;
        for (int i = 0; i < prefix.length(); i++) {
            if(temp.children.containsKey(prefix.charAt(i))){
                temp = temp.children.get(prefix.charAt(i));
            }else return false;
        }
        return true;
    }
}

class TrieNode{
    char value;
    Map<Character, TrieNode> children = new HashMap<>();
    boolean isTerminal;

    public TrieNode(char value) {
        this.value = value;
        this.isTerminal = false;
    }
}