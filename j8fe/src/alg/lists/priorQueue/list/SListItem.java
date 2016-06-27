package alg.lists.priorQueue.list;

public class SListItem implements Comparable{

    public int value;
    public SListItem next;

    @Override
    public int compareTo(Object o) {
        if(!(o instanceof SListItem))
            return 0;
        else
            return value - ((SListItem)o).value;
    }
}
