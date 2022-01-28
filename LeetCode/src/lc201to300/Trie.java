package lc201to300;

import java.util.HashMap;
import java.util.Map;

public class Trie {

    public static void main(String[] args) {
        Trie trie = new Trie();
        //["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
        //[[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));
    }


    private TrieNode rootNode;

    public Trie() {
        rootNode = new TrieNode();
    }

    public void insert(String word) {
        if (word == null) return;
        TrieNode tempNode = rootNode;
        for (int i = 0; i < word.length(); ++i) {
            char ch = word.charAt(i);
            TrieNode subNode = tempNode.getSubNode(ch);
            if (subNode == null) {
                subNode = new TrieNode();
                tempNode.addSubNode(ch, subNode);
            }

            tempNode = subNode;

            if (i == word.length() - 1) {
                tempNode.setEnd(true);
            }
        }
    }

    public boolean search(String word) {
        if (word == null || word.length()==0) return false;
        TrieNode tempNode = rootNode;
        for(int i = 0; i<word.length(); ++i){
            char ch = word.charAt(i);
            TrieNode subNode = tempNode.getSubNode(ch);
            if(subNode == null) return false;
            tempNode = subNode;
        }
        return tempNode.isEnd();
    }

    public boolean startsWith(String prefix) {
        if (prefix == null || prefix.length()==0) return false;
        TrieNode tempNode = rootNode;
        for(int i = 0; i<prefix.length(); ++i){
            char ch = prefix.charAt(i);
            TrieNode subNode = tempNode.getSubNode(ch);
            if(subNode == null) return false;
            tempNode = subNode;
        }
        return true;
    }

    class TrieNode {
        private boolean isEnd = false;
        private Map<Character, TrieNode> subNodes = new HashMap<>();

        public boolean isEnd() {
            return isEnd;
        }

        public void setEnd(boolean end) {
            isEnd = end;
        }

        public void addSubNode(Character c, TrieNode node) {
            subNodes.put(c, node);
        }

        public TrieNode getSubNode(Character c) {
            return subNodes.get(c);
        }
    }
}
