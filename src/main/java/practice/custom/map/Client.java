package practice.custom.map;

public class Client {
    public static void main(String[] args) {
        CustomLinkedHashMap<String, String> customLinkedHashMap = new CustomLinkedHashMap<>();
        customLinkedHashMap.put("imran", "1");
        customLinkedHashMap.put("Hossain", "2");
        customLinkedHashMap.put("faruk", "3");
        customLinkedHashMap.put("iqra", "4");
        customLinkedHashMap.put("shabnam", "5");
        customLinkedHashMap.put("alam", "6");

        System.out.println(customLinkedHashMap.get("Hossain"));

        for(String key: customLinkedHashMap.keySet()){
            System.out.println(key);
        }
    }
}
