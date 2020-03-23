package queue;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class HandmadeQueue<T> {

    private Item<T> firstItem;
    private Item<T> tail;

    boolean isEmpty() {
        return firstItem == tail;
    }

    public void push(T data) {
        isNull(data);

        Item<T> item = new Item<T>(data);
        if (firstItem == null) {
            firstItem = item;
            tail = item;
        } else {
            Item secondItem = firstItem;
            firstItem = item;
            firstItem.setNextItem(secondItem);
        }
    }

    public T pop() {
        if (firstItem == tail) {
            return tail == null ? null : tail.getData();
        }
        Item<T> item = firstItem;
        Item<T> oldTail = tail;
        while (true) {
            if (item.getNextItem().equals(tail)) {
                tail = item;
                return oldTail.getData();
            } else {
                item = item.getNextItem();
            }
        }
    }

    public List<T> searchByCriteria(Predicate<T> criterion) {
        List<T> suitableItem = new ArrayList<>();
        if (firstItem == null){
            return suitableItem;
        }
        Item<T> item = firstItem;

        while (item != tail) {
            if (criterion.test(item.getData())) {
                suitableItem.add(item.getData());
            }
            item = item.getNextItem();
        }

        return suitableItem;
    }

    private void isNull(T data) {
        if (data == null) {
            throw new NullPointerException("Element cannot be null!");
        }
    }

    @Override
    public String toString() {

        return "HandmadeQueue{\n" + toString(firstItem) + "}";
    }

    private String toString(Item item) {
        if (item.getNextItem() != null) {
            return item.toString() + '\n' + toString(item.getNextItem());
        }
        return item.toString();
    }

}
