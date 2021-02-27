package practice.queue;

public class Client {
    public static void main(String[] args) {
        StackUsingQueue.Stack2Q<String> stack = new StackUsingQueue.Stack2Q();

        stack.push("Imran");
        stack.push("Iqra");
        stack.push("Shabnam");
        stack.push("Hossain");

        System.out.println(stack.pop());

        StackUsingQueue.Stack1Q<String> stack1Q = new StackUsingQueue.Stack1Q(3);

        stack1Q.push("Imran");
        stack1Q.push("Iqra");
        stack1Q.push("Shabnam");
        System.out.println(stack1Q.pop());
        stack1Q.push("Hossain");
        System.out.println(stack1Q.pop());
        System.out.println(stack1Q.pop());
        System.out.println(stack1Q.pop());
        //System.out.println(stack1Q.pop());
    }
}
