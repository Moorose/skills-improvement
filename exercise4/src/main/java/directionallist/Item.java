package directionallist;

public class Item<T> {

    private T data;
    private Item nextItem;

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

    public Item getNextItem() {
        return nextItem;
    }

    public void setNextItem(Item nextItem) {
        this.nextItem = nextItem;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
