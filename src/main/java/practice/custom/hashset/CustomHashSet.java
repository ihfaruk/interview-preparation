package practice.custom.hashset;

import java.util.ArrayList;
import java.util.List;

/**
 * Create a custom hash set with out using hashmap.
 *
 * @param <T>
 */
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
        if (key == null)
            throw new RuntimeException("Key can not be null");
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
        if (key == null)
            throw new RuntimeException("Key can not be null");
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
        if (key == null)
            throw new RuntimeException("Key can not be null");
        int hashCode = key.hashCode();
        int index = hashCode % size;
        List<T> bucketList = array[index];
        if (bucketList != null) {
            bucketList.remove(key);
        }
    }

    // rehashing technique
}