package directionallist;

public class OneWayList<T> {

    private Item<T> firstItem;

    public OneWayList() {
    }

    public OneWayList(T data) {
        isNull(data);

        this.firstItem = new Item(data);
    }

    public T getFirstItem() {    //  O(1)
        return (T) firstItem.getData();
    }

    public T getNextItem(T data) { //  O(n^2)
        isNull(data);
        Item<T> item = findItem(data);

        if (item == null || item.getNextItem() == null) {
            return null;
        }
        return item.getNextItem().getData();
    }

    private Item findItem(T data) {     //  O(n)
        if (firstItem != null) {
            if (firstItem.getData().equals(data)) {
                return firstItem;
            } else {
                return findItem(data, firstItem.getNextItem());
            }
        }
        return null;
    }

    private Item findItem(T data, Item nextItem) {
        if (nextItem != null) {
            return nextItem.getData().equals(data) ?
                    nextItem : findItem(data, nextItem.getNextItem());
        }
        return null;
    }

    public T add(T data) { //  O(n)
        isNull(data);

        Item<T> item = new Item<T>(data);
        if (firstItem == null) {
            firstItem = item;
            return data;
        }
        getLastItem(firstItem).setNextItem(item);
        return null;
    }

    public boolean remove(T data) { //  O(n)
        isNull(data);
        Item<T> removeItem = new Item<T>(data);

        if (firstItem == null) {
            return false;
        }
        if (firstItem.equals(removeItem)) {
            firstItem = firstItem.getNextItem();
            return true;
        }
        return remove(firstItem, firstItem.getNextItem(), removeItem);
    }


    private boolean remove(Item previousItem, Item currentItem, Item removeItem) {
        if (currentItem.equals(removeItem)) {
            previousItem.setNextItem(currentItem.getNextItem());
            return true;
        }
        return currentItem.getNextItem() != null && remove(currentItem, currentItem.getNextItem(), removeItem);
    }

//    public boolean equals(T item1, T item2) {
//        return item1.equals(item2);
//    }

    private Item getLastItem(Item<T> item) { //  O(n)
        Item nextItem = item.getNextItem();

        if (nextItem == null) {
            return item;
        }
        return getLastItem(nextItem);
    }

    private void isNull(T data) {
        if (data == null) {
            throw new NullPointerException("Element cannot be null!");
        }
    }

    @Override
    public String toString() {

        return "OneWayList{\n" + toString(firstItem) + "}";
    }

    private String toString(Item item) {
        if (item.getNextItem() != null) {
            return item.toString() + '\n' + toString(item.getNextItem());
        }
        return item.toString();
    }
}
