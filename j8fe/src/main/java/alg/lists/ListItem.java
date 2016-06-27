package alg.lists;

import java.util.List;

public class ListItem<T> {

    public T value;
    public ListItem<T> next;

    public ListItem(T value) {
        this.value = value;
    }

    public ListItem<T> find(ListItem<T> elem){
        if(this.equals(elem)){
            return this;
        }else {
            return next == null ? null : next.find(elem);
        }
    }

    @Override
    public String toString() {
        return "SListItem{" +
                "value=" + value +
                ", isLast=" + (next == null) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ListItem<?> listItem = (ListItem<?>) o;

        return value != null ? value.equals(listItem.value) : listItem.value == null;

    }

    @Override
    public int hashCode() {
        return value != null ? value.hashCode() : 0;
    }
}
