package heap;

import java.util.PriorityQueue;

public class HeapApp {
    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> b - a);
        for(int i=10; i>0; i--) {
            priorityQueue.add(i);
        }

        while (!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.poll());
        }
    }
}
