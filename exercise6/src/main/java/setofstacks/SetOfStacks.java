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

    public void push(T data) {    //   O (n)
        Stack stack = stacks.get(stacks.size() - 1);   //   O (1)
        if (!stack.isFull()) {
            stack.push(data);                        //   O (n)
        } else if (stacks.size() < setSize) {
            stacks.add(new Stack<T>(stackSize));     //   O (1)
            stacks.get(stacks.size() - 1).push(data);  //   O (n)
        } else
            throw new ArrayStoreException("Set is full");
    }

    public T pop() {      //   O (n)
        Stack<T> stack = stacks.get(stacks.size() - 1);      //   O (1)
        if (stack == null) {
            return null;
        }
        if (stack.isEmpty()) {
            if (stacks.size() - 1 == 0) {
                return null;
            }
            stacks.remove(stacks.size() - 1);      //   O (n)
            return pop();    //   O (n)
        }
        return stack.pop();      //   O (n)
    }

    public T popAt(int index) {   //   O (n^2)
        if (index >= setSize) {
            throw new IndexOutOfBoundsException();
        }
        if (stacks.size() < index) {
            return null;
        }
        T data = stacks.get(index).pop();   //   O (n)
        voidFilling(index);   //   O (n^2)
        return data;
    }

    private void voidFilling(int index) {   //   O (n^2)
        for (int i = index; i < stacks.size()-1; i++) {
            Stack<T> source = stacks.get(i + 1);      //   O (1)
            if (source.isEmpty()) {
                return;
            }
            merge(stacks.get(i), source);   //   O (2n)
        }
    }

    private void merge(Stack<T> needy, Stack<T> source) {   //   O (2n)
        while (!needy.isFull() & !source.isEmpty()) {   // при вызове посл каждого popAt выполнится один раз
            needy.push(source.removeBottom());         //   O (2n)
        }
    }

    @Override
    public String toString() {
        return "SetOfStacks{" +
                "stacks=\n" + stacks +
                ",\n stack capacity =" + stackSize +
                ", set size=" + setSize +
                '}';
    }
}
