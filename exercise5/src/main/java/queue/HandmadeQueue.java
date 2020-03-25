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

    public void push(T data) {  //  O(1)
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

    public T pop() {        // O(n)
        if (firstItem == tail) {
            if (tail != null) {
                firstItem = null;
                T data = tail.getData();
                tail = null;
                return data;
            } else {
                return null;
            }
        }
        Item<T> item = firstItem;
        Item<T> oldTail = tail;
        while (true) {
            if (item.getNextItem().equals(tail)) {
                tail = item;
                tail.setNextItem(null);
                return oldTail.getData();
            } else {
                item = item.getNextItem();
            }
        }
    }

//    public List<T> searchByCriteria(Predicate<T> criterion) {
//        List<T> suitableItem = new ArrayList<>();
//        if (firstItem == null) {
//            return suitableItem;
//        }
//        Item<T> item = firstItem;
//
//        while (item != tail) {
//            if (criterion.test(item.getData())) {
//                suitableItem.add(item.getData());
//            }
//            item = item.getNextItem();
//        }
//
//        return suitableItem;
//    }

    public T getByCriteria(Predicate<T> criterion) {        // O(n)
        if (firstItem == null) {
            return null;
        }
        Item<T> item = firstItem;
        Item<T> beforeItem = null;

        while (item != null) {
            if (criterion.test(item.getData())) {
                if (item == firstItem) {
                    if (firstItem.getNextItem() == null) {
                        firstItem = null;
                        tail = null;
                    } else {
                        firstItem = firstItem.getNextItem();
                    }
                } else if (item == tail) {
                    tail = beforeItem;
                    if (tail != null) {
                        tail.setNextItem(null);
                    }
                } else {
                    if (beforeItem != null) {
                        beforeItem.setNextItem(item.getNextItem());
                    }
                }
                return item.getData();
            }
            beforeItem = item;
            item = item.getNextItem();
        }
        ;

        return null;
    }

    private void isNull(T data) {
        if (data == null) {
            throw new NullPointerException("Element cannot be null!");
        }
    }

    @Override
    public String toString() {

        return "HandmadeQueue{ " + toString(firstItem) + " }";
    }

    private String toString(Item item) {
        if (item.getNextItem() != null) {
            return item.toString() + ' ' + toString(item.getNextItem());
        }
        return item.toString();
    }

}
