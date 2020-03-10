package directionallist;

public class DirectionalList <T> {

    private Item<T> firstItem;

    public DirectionalList(Item<T> firstItem) {
        this.firstItem = firstItem;
    }

    private Item<T> getLastData() {

    }

    public T insert(T data) {
        if (firstItem == null) {
            firstItem = new Item<T>(data);
            return data;
        }



        return item.getData();
    }
}
