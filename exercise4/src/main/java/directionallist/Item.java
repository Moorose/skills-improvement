package directionallist;

public class Item<T> {

    private T data;
    private Item<T> nextItem;

    public Item(T data) {
        this(data, null);
    }

    private Item(T data, Item nextItem) {
        this.data = data;
        this.nextItem = nextItem;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Item<T> getNextItem() {
        return nextItem;
    }

    public void setNextItem(Item<T> nextItem) {
        this.nextItem = nextItem;
    }

    public boolean equals(Item<T> item) {
        return data.equals(item.data);
    }

    @Override
    public String toString() {
        return data.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) return false;
        Item<?> item = (Item<?>) o;
        return data.equals(item.data);
    }
}
