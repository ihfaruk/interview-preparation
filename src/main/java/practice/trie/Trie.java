package practice.trie;

public class Trie {
    private CharNode head;

    public Trie() {
        head = new CharNode();
    }

    public void insert(String keyword) {
        if (head == null) {
            head = new CharNode();
        }
        //CharNode[] childs = head.getChilds();
        CharNode currentNode = head;
        if (keyword != null) {
            char[] chars = keyword.toCharArray();
            for(char ch : chars){
                int index = getIndex(ch);
                if(currentNode.getChilds()==null){
                    currentNode.setChilds(CharNode.initializeChild());
                }
                CharNode charNode = currentNode.getChilds()[index];
                charNode.setPresent(true);
                currentNode=charNode;
            }
        }

    }

    public void search(String keyword) {

    }

    public void remove(String keyword) {

    }

    private int getIndex(char ch) {
        int index = ch - 97;
        return index;
    }
}
