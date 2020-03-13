package directionallist;

public class OneWayList<T> {

    private Item firstItem;

    public OneWayList() {
    }

    public OneWayList(Item<T> firstItem) {
        this.firstItem = firstItem;
    }

    public T add(T data) {
        Item<T> item = new Item<T>(data);
        if (firstItem == null) {
            firstItem = item;
            return data;
        }
        getLastItem(firstItem).setNextItem(item);
        return null;
    }

    public boolean remove(T data) {
        Item<T> removeItem = new Item<T>(data);

        if (firstItem.equals(removeItem)) {
            firstItem = null;
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

    public boolean equals(T item1, T item2) {
        return item1.equals(item2);
    }

    private Item getLastItem(Item<T> item) {
        Item nextItem = item.getNextItem();

        if (nextItem == null) {
            return item;
        }
        return getLastItem(nextItem);
    }

    @Override
    public String toString() {

        return "OneWayList{\n" + toString(firstItem)  + "}";
    }

    private String toString(Item item) {
        if (item.getNextItem() != null) {
            return item.toString() +'\n'+ toString(item.getNextItem());
        }
        return item.toString();
    }
}
