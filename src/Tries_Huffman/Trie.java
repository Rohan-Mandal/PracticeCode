package Tries_Huffman;

class TriesNode{
    char data;
    boolean isTerminal;
    TriesNode children[];

    public TriesNode(char data){
        this.data = data;
        this.isTerminal = false;
        this.children = new TriesNode[26];
    }
}
public class Trie {
    private TriesNode root;
    public Trie(){
        root = new TriesNode('\0');
    }

    private void addHelper(TriesNode root, String word){
        if(word.length() == 0){
            root.isTerminal = true;
            return;
        }
        int childIndex = word.charAt(0) - 'A';
        TriesNode child = root.children[childIndex];
        if (child == null){
            child = new TriesNode(word.charAt(0));
            root.children[childIndex] = child;
        }
        addHelper(child, word.substring(1));
    }

    public void add(String word){
        addHelper(root, word);
    }

    public boolean searchHelper(TriesNode root, String word){
        if(word.length() == 0){
            return root.isTerminal;
        }
        int childIndex = word.charAt(0) -'A';
        TriesNode child = root.children[childIndex];
        if(child == null){
            return false;
        }
        return searchHelper(child,word.substring(1));
    }

    public boolean search(String word){
        return searchHelper(root,word);
    }
    public void remove(String word){

    }
}
