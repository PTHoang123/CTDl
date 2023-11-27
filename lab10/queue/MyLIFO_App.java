package lab10.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MyLIFO_App {
    // method stutter that accepts a queue of integers as
    //a parameter and replaces
     // every element of the queue with two copies of that
    //element
    // front [1, 2, 3] back
    // becomes
    // front [1, 1, 2, 2, 3, 3] back
    public static <E> void stutter(Queue<E> input) {
        int size = input.size();
		for (int i = 0; i < size; i++) {
			E line = input.remove();
			input.add(line);
			input.add(line);
		}
    }
    public static <E> void mirror(Queue<E> input) {
        Stack<E> stack = new Stack<>();
        int size = input.size();
        for(int i = 0; i < size; i++) {
            E line = input.remove();
            stack.push(line);
            input.add(line);
        }
        for(int i = 0; i < size; i++) {
            input.add(stack.pop());
        }
    }
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        stutter(queue);
        System.out.println(queue);
        mirror(queue);
        System.out.println(queue);
    }
}