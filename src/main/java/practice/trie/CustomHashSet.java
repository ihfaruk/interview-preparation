package practice.trie;

import java.util.ArrayList;
import java.util.List;

public class CustomHashSet<T> {
    private List<T>[] array;
    private int size = 10;

    public CustomHashSet() {
        this.array = new List[size];
    }

    public CustomHashSet(int size) {
        this.size = size;
        this.array = new List[size];
    }

    public void add(T key) {
        int hashCode = key.hashCode();
        int index = hashCode % size;
        List<T> bucketList = array[index];
        if (bucketList == null) {
            bucketList = new ArrayList<T>();
            bucketList.add(key);
            array[index] = bucketList;
        } else {
            bucketList.add(key);
        }
    }

    public boolean contains(T key) {
        int hashCode = key.hashCode();
        int index = hashCode % size;
        List<T> bucketList = array[index];
        if (bucketList == null) {
            return false;
        } else {
            for (T t : bucketList) {
                if (t.equals(key)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void remove(T key) {
        int hashCode = key.hashCode();
        int index = hashCode % size;
        List<T> bucketList = array[index];
        if (bucketList != null) {
            bucketList.remove(key);
        }
    }

    private void reHash() {

    }
}