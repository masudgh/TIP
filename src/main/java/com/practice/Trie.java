package com.practice;


import java.util.HashMap;
import java.util.Map;

class TrieNode {
    char ch;
    Map<Character, TrieNode> children;
    boolean isWord;

    public TrieNode(char ch) {
        this.ch = ch;
        children = new HashMap<>();
    }
}
public class Trie {
    TrieNode root ;
    Trie(){
        root = new TrieNode( (char) 0);
    }

    void insert(String str){
        TrieNode node = root;

        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            TrieNode child = node.children.get(ch);
            if(child == null){
                child = new TrieNode(ch);
                node.children.put(ch,child);
            }
            node = child;
        }
        node.isWord = true;
    }

    boolean prefixMatches(String str){
        TrieNode node = root;

        for(int i=0; i<str.length(); i++) {
             char ch = str.charAt(i);
             TrieNode child =  node.children.get(ch);
             if(child == null) return false;
             //if(child.isWord) break;
             node = child;
        }

        return true;
    }

    boolean isWordExist(String str){
        TrieNode node = root;

        for(int i=0; i<str.length(); i++) {
            char ch = str.charAt(i);
            TrieNode child =  node.children.get(ch);
            if(child == null) {
                return false;
            }else{
                if(child.isWord && i ==str.length()-1) return true;
            }

            node = child;
        }

        return false;
    }

}


class TrieDemo{

    public static void main (String [] args){


        Trie myTrie = new Trie();

        myTrie.insert("apple");
        myTrie.insert("app");
        myTrie.insert("art");
        myTrie.insert("ark");
        myTrie.insert("cat");


    }




}
