package stacks;

public class ArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack<Integer> iArrayStack = new ArrayStack<>();
        System.out.println(iArrayStack);
        System.out.println(iArrayStack.isEmpty());
        System.out.println(iArrayStack.top());
        iArrayStack.push(10);
        iArrayStack.push(20);
        iArrayStack.push(30);
        System.out.println(iArrayStack);
        System.out.println(iArrayStack.pop());
        System.out.println(iArrayStack);
        System.out.println(iArrayStack.pop());
        System.out.println(iArrayStack);
        System.out.println(iArrayStack.isEmpty());
        System.out.println(iArrayStack.top());
        System.out.println(iArrayStack.pop());
        System.out.println(iArrayStack);
        System.out.println(iArrayStack.isEmpty());
        System.out.println(iArrayStack.top());

        ArrayStack<String> sArrayStack = new ArrayStack<>();
        System.out.println(sArrayStack.pop());
        sArrayStack.push("Rust");
        sArrayStack.push("Go");
        sArrayStack.push("Python");
        System.out.println(sArrayStack);
    }
}
