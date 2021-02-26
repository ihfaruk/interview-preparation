package practice.cache;

public class Client {
    public static void main(String[] args) {
        LRUCache<String, String> lruCache = new LRUCache<>(3);

        lruCache.insert("imran", "1");
        lruCache.insert("shabnam", "2");
        lruCache.insert("iqra", "3");
        lruCache.insert("hossain", "4");


        for (String s : new String[]{"imran", "shabnam", "iqra", "hossain"}){
            String value = lruCache.get(s);
            System.out.println(value);
        }

    }
}
