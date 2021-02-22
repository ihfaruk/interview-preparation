package practice.trie;

public class Client {
    public static void main(String[] args) {
        Trie trie = new Trie();
        String[] names = new String[]{
          "imran",
          "hossain",
          "faruk",
          "iqra"
        };

        for(String name: names) {
            trie.insert(name);
        }
        System.out.println("");
    }
}
