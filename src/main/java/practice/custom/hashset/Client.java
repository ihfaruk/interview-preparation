package practice.custom.hashset;

public class Client {
    public static void main(String[] args) {
        CustomHashSet<Integer> customHashSet = new CustomHashSet<>(20);
        customHashSet.add(10);
        customHashSet.add(20);
        customHashSet.add(30);
        customHashSet.add(40);
        System.out.println(customHashSet.contains(40));
        customHashSet.remove(40);
        System.out.println(customHashSet.contains(40));
    }
}
