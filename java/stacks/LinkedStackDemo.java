package stacks;

public class LinkedStackDemo {
    public static void main(String[] args) {
        Stack<String> sLinkedStack = new LinkedStack<>();
        System.out.println(sLinkedStack.size());
        System.out.println(sLinkedStack.pop());
        System.out.println(sLinkedStack.top());
        sLinkedStack.push("Rust");
        System.out.println(sLinkedStack.size());
        System.out.println(sLinkedStack.top());
        sLinkedStack.push("Python");
        sLinkedStack.push("Go");
        System.out.println(sLinkedStack.size());
        System.out.println(sLinkedStack.top());
        System.out.println(sLinkedStack);
        System.out.println(sLinkedStack.pop());
        System.out.println(sLinkedStack);
        System.out.println(sLinkedStack.pop());
        System.out.println(sLinkedStack);
        System.out.println(sLinkedStack.pop());
        System.out.println(sLinkedStack);
        System.out.println(sLinkedStack.pop());
        System.out.println(sLinkedStack.isEmpty());
    }
}
