package practice.trie;

public class CharNode {
    private boolean isPresent;
    private CharNode[] childs;

    public CharNode() {
        isPresent = false;
        childs = null;
    }
    public static CharNode[] initializeChild(){
        CharNode[] childs = new CharNode[26];
        for(int i=0; i<26;i++){
            childs[i]=new CharNode();
        }
        return childs;
    }

    public CharNode(boolean isPresent) {
        this.isPresent = isPresent;
    }

    public boolean isPresent() {
        return isPresent;
    }

    public void setPresent(boolean present) {
        isPresent = present;
    }

    public CharNode[] getChilds() {
        return childs;
    }

    public void setChilds(CharNode[] childs) {
        this.childs = childs;
    }
}
