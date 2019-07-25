package trie;

public class Trie {

    static final int ALPHABAT_SIZE = 26;

    static class TrieNode{
        TrieNode children[] = new TrieNode[ALPHABAT_SIZE];

        boolean isEndOfWord = false;
    }

    static TrieNode root ;

    static void  insert(String str){
        int length = str.length();
        TrieNode node = root;
        for(int i = 0;i<length;i++){
            if(node.children[str.charAt(i) - 'a'] == null){
                node.children[str.charAt(i) - 'a'] = new TrieNode();
            }
            node = node.children[str.charAt(i) - 'a'];
        }

        node.isEndOfWord = true;
    }

    static boolean search(String key)
    {
        int level;
        int length = key.length();
        int index;
        TrieNode pCrawl = root;

        for (level = 0; level < length; level++)
        {
            index = key.charAt(level) - 'a';

            if (pCrawl.children[index] == null)
                return false;

            pCrawl = pCrawl.children[index];
        }

        return (pCrawl != null && pCrawl.isEndOfWord);
    }

    // Driver
    public static void main(String args[])
    {
        // Input keys (use only 'a' through 'z' and lower case)
        String keys[] = {"the", "a", "there", "answer", "any",
                "by", "bye", "their"};

        String output[] = {"Not present in trie", "Present in trie"};


        root = new TrieNode();

        // Construct trie
        int i;
        for (i = 0; i < keys.length ; i++)
            insert(keys[i]);

        // Search for different keys
        if(search("the") == true)
            System.out.println("the --- " + output[1]);
        else System.out.println("the --- " + output[0]);

        if(search("these") == true)
            System.out.println("these --- " + output[1]);
        else System.out.println("these --- " + output[0]);

        if(search("their") == true)
            System.out.println("their --- " + output[1]);
        else System.out.println("their --- " + output[0]);

        if(search("thaw") == true)
            System.out.println("thaw --- " + output[1]);
        else System.out.println("thaw --- " + output[0]);

    }

}
