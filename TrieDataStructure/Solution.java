import java.util.*;
class TrieNode{
    HashMap<Character, TrieNode> nodes;
    boolean isEnd;

    TrieNode(){
        this.nodes = new HashMap<Character, TrieNode>();
        this.isEnd = false;
    }
}
public class Solution{
    TrieNode root;
    public Solution(){
        this.root = new TrieNode();
    }

    public void insert(String key){
        TrieNode pCrawl = this.root;
        for(int i = 0;i<key.length();i++){
            if(pCrawl.nodes.get(key.charAt(i)) == null){
                pCrawl.nodes.put(key.charAt(i), new TrieNode());
            }
            pCrawl = pCrawl.nodes.get(key.charAt(i));
        }
        pCrawl.isEnd = true;
    }

    public boolean search(String key){
        TrieNode pCrawl = this.root;
        for(int i = 0;i<key.length();i++){
            if(pCrawl.nodes.get(key.charAt(i)) == null){
                return false;
            }else{
                pCrawl = pCrawl.nodes.get(key.charAt(i));
            }
        }
        return pCrawl != null && pCrawl.isEnd;
    }

    public static void traversal(TrieNode node){
        
    }

    public static void main(String args[]){
        Solution sol = new Solution();
        String keys[] = {"the", "a", "there", "answer", "any", "by", "bye", "their"};
        String output[] = {"Not present in trie", "Present in trie"}; 
        for (int i = 0; i < keys.length ; i++) 
            sol.insert(keys[i]); 
        System.out.println("sol.search "+sol.search("the"));
        if(sol.search("the") == true) 
            System.out.println("the --- " + output[1]); 
        else System.out.println("the --- " + output[0]); 
          
        if(sol.search("these") == true) 
            System.out.println("these --- " + output[1]); 
        else System.out.println("these --- " + output[0]); 
          
        if(sol.search("their") == true) 
            System.out.println("their --- " + output[1]); 
        else System.out.println("their --- " + output[0]); 
          
        if(sol.search("thaw") == true) 
            System.out.println("thaw --- " + output[1]); 
        else System.out.println("thaw --- " + output[0]); 
    }
}