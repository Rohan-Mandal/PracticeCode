package Tries_Huffman;

public class TrieUse {
    public static void main(String[] args) {
        Trie t = new Trie();
        t.add("NOTE");
        t.add("AND");

        System.out.println(t.search("NOTE"));
    }
}
