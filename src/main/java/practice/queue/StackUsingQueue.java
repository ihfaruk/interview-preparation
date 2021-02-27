package practice.queue;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {

    /**
     * Implementing stack using 2 queues
     */
    public static class Stack2Q<T> {
        private Queue<T> queueFirst;
        private Queue<T> queueSecond;

        public Stack2Q() {
            queueFirst = new LinkedList<>();
            queueSecond = new LinkedList<>();
        }

        public void push(T value) {
            while (queueFirst.peek() != null) {
                queueSecond.add(queueFirst.poll());
            }

            queueFirst.add(value);

            while (queueSecond.peek() != null) {
                queueFirst.add(queueSecond.poll());
            }
        }

        public T pop() {
            return queueFirst.poll();
        }
    }

    public static class Stack1Q<T> {
        private Queue<T> queue;

        private int length;

        private int capacity;

        public Stack1Q() {
            queue = new LinkedList<>();
            capacity = 11;
        }

        public Stack1Q(int capacity) {
            this();
            this.capacity = capacity+1;
        }

        public void push(T value) {
            if (length <= (capacity - 2) && value != null) {
                length++;
                queue.add(value);
            } else {
                throw new RuntimeException("Overflow");
            }
        }

        public T pop() {
            if (length > 0) {
                queue.add(null);
                T value = null;
                while (queue.peek() != null) {
                    value = queue.poll();
                    if (queue.peek() != null) {
                        queue.add(value);
                    }
                }
                queue.poll();
                length--;
                return value;
            } else
                throw new RuntimeException("Underflow");
        }
    }
}
