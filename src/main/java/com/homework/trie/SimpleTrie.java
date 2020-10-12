package com.homework.trie;


import java.util.HashMap;
import java.util.Map;

class TrieNode {
    char ch;
    Map<Character, TrieNode> childrenMap;
    boolean isWord;

    TrieNode(char ch) {
        this.ch = ch;
        childrenMap = new HashMap<>();
    }
}

public class SimpleTrie {

    TrieNode root;

    public SimpleTrie() {
        this.root = new TrieNode((char)0);
    }

    public void insert(String str) {
        TrieNode node = root;
        for(int i=0; i< str.length(); i++) {
            char ch = str.charAt(i);
            TrieNode child = node.childrenMap.get(ch);
            if(child == null) {
                child = new TrieNode(ch);
                node.childrenMap.put(ch, child);
            }
            node = child;
        } //end of for loop
        node.isWord = true;
    }
    //boolean startsWith(String str)
    public boolean prefixMatches(String str) {
        TrieNode node = root;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            TrieNode child = node.childrenMap.get(ch);
            if(child == null) {
                return false;
            }
            node = child;
        } // for loop
        return true;
    }

    public boolean isWordExist(String str) {
        TrieNode node = root;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            TrieNode child = node.childrenMap.get(ch);
            if(child == null) {
                return false;
            } else {
                if(child.isWord && i==str.length()-1) {
                    return true;
                }
            }
            node = child;
        } // for loop
        return false;
    }
}
