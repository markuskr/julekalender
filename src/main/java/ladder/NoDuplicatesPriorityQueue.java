package ladder;

import java.util.PriorityQueue;

public class NoDuplicatesPriorityQueue<E> extends PriorityQueue<E> {
    @Override
    public boolean offer(E e) {
        boolean isAdded = false;
        if (!super.contains(e)) {
            isAdded = super.offer(e);
        }
        return isAdded;
    }

    public NoDuplicatesPriorityQueue(int cap){
        super(cap);
    }
}
