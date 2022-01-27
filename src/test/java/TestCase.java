import com.google.common.collect.Queues;

import java.util.PriorityQueue;

public class TestCase {
    public static void main(String[] args) {
        PriorityQueue<String> queue = Queues.newPriorityQueue();
         queue.add("aa");
         queue.add("bc");
         queue.add("ab");
        queue.add("bc");
        while (queue.peek() !=null){
            System.out.println(queue.poll());
        }
    }
}
