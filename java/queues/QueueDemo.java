package queues;

public class QueueDemo {
    public static void main(String[] args) {
        Queue<Integer> queue1 = new ArrayQueue<>();
        System.out.println(queue1.isEmpty());
        System.out.println(queue1.size());
        queue1.enqueue(10);
        queue1.enqueue(20);
        System.out.println(queue1.isEmpty());
        System.out.println(queue1.size());
        System.out.println(queue1.first());
        System.out.println(queue1.dequeue());
        System.out.println(queue1.dequeue());
        System.out.println(queue1.isEmpty());
        System.out.println(queue1.size());
        System.out.println(queue1.first());

        Queue<String> queue2 = new LinkedQueue<>();
        queue2.enqueue("Rust");
        queue2.enqueue("Python");
        queue2.enqueue("Go");
        System.out.println(queue2.isEmpty());
        System.out.println(queue2.size());
        System.out.println(queue2.first());
        System.out.println(queue2.dequeue());
        System.out.println(queue2.dequeue());
        System.out.println(queue2.dequeue());
        System.out.println(queue2.isEmpty());
        System.out.println(queue2.size());
        System.out.println(queue2.first());

        CircularQueue<String> studentQueue = new LinkedCircularQueue<>();
        studentQueue.enqueue("Ben");
        studentQueue.enqueue("Raj");
        studentQueue.enqueue("James");
        System.out.println(studentQueue.size());
        System.out.println(studentQueue.first());
        System.out.println(studentQueue.isEmpty());
        studentQueue.rotate();
        System.out.println("After rotation");
        System.out.println(studentQueue.size());
        System.out.println(studentQueue.first());
        System.out.println(studentQueue.isEmpty());
        System.out.println(studentQueue.dequeue());
        System.out.println(studentQueue.dequeue());
        System.out.println(studentQueue.dequeue());
        System.out.println(studentQueue.isEmpty());
    }
}
