import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueExample {
    public static void main(String[] args){
        // PriorityQueue <Integer> pq = new PriorityQueue<Integer>();

        // pq.add(2);
        // pq.add(1);
        // pq.add(4);
        // pq.add(3);

        // while(pq.isEmpty() == false){
        //     System.out.println(pq.poll());
        // }

        Comparator <Integer> customComparator = new Comparator <Integer> (){
            @Override
            public int compare(Integer x, Integer y){
                if(x % 2 != y % 2){
                    if(x % 2 == 0){
                        return 1;
                    }else{
                        return -1;
                    }
                }
                return Integer.compare(x, y);
            }
        };
        PriorityQueue <Integer> cpq = new PriorityQueue <Integer> (customComparator);

        cpq.add(2);
        cpq.add(1);
        cpq.add(4);
        cpq.add(3);

        while(cpq.isEmpty() == false){
            System.out.println(cpq.poll());
        }
    }
}
