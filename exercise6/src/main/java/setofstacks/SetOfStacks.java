package setofstacks;

import java.util.ArrayList;
import java.util.List;

public class SetOfStacks<T> {

    private final List<Stack<T>> stacks;
    private int stackSize, setSize;

    public SetOfStacks(int stackSize, int setSize) {
        this.stackSize = stackSize;
        this.setSize = setSize;
        stacks = new ArrayList<>(setSize);
        stacks.add(new Stack<>(stackSize));
    }

    public void push(T data) {
        Stack stack = stacks.get(0);
        if (!stack.isFull()) {
            stack.push(data);
        } else if (stacks.size() < setSize) {
            stacks.add(0, new Stack<>(stackSize));
            stacks.get(0).push(data);
        } else throw new ArrayStoreException("Set is full");
    }

    public T pop() {
        Stack<T> stack = stacks.get(stacks.size()-1);
        return stack.pop();
    }

    public T popAt(int index) {
        if (index >= setSize) {
            throw new IndexOutOfBoundsException();
        }
        if (stacks.size() < index) {
            return null;
        }
        T data = stacks.get(index).pop();
        voidFilling(index);
        return data;
    }

    private void voidFilling(int index) {
        for (int i = index; i > 0; i--) {
            Stack<T> source = stacks.get(i - 1);
            if (source.isEmpty()) {
                return;
            }
            merge(stacks.get(i), source);
        }
    }

    private void merge(Stack<T> needy, Stack<T> source) {
        while (!needy.isFull() & !source.isEmpty()) {
            needy.push(source.pop());
        }
    }

    @Override
    public String toString() {
        return "SetOfStacks{" +
                "stacks=\n" + stacks +
                ",\n stackSize=" + stackSize +
                ", setSize=" + setSize +
                '}';
    }
}
