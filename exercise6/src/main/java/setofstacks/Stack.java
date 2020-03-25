package setofstacks;

import java.util.*;

public class Stack<T> {

    private BoundedList<T> stack;
    private int stackSize;

    public Stack(int size) {
        stack = new BoundedList<T>(size);
        stackSize = size;
    }

    public void push(T data) {
        if (stack.size() < stackSize) {
            stack.add(0, data);
            return;
        }
        throw new ArrayStoreException("Stack is full");
    }


    public T pop() {
        T element = stack.get(0);
        stack.remove(element);
        return element;
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public boolean isFull() {
        return stack.size() == stackSize;
    }

    private class BoundedList<T> {
        private ArrayList<T> mas;

        @Override
        public String toString() {
            return mas.toString();
        }

        public BoundedList(int size) {
            this.mas = new ArrayList<>(stackSize);
        }

        private void checkIndex(int index) {
            if (index > stackSize) {
                throw new IndexOutOfBoundsException();
            }
        }

        public int size() {
            return mas.size();
        }

        public boolean isEmpty() {
            return mas.isEmpty();
        }

        public boolean contains(Object o) {
            return mas.contains(o);
        }

        public boolean add(T t) {
            if (size() < stackSize) {
                mas.add(t);
                return true;
            }
            return false;
        }

        public void clear() {
            mas = new ArrayList<T>(stackSize);
        }

        public T get(int index) {
            checkIndex(index);
            if (mas.size() <= index) {
                return null;
            }
            return mas.get(index);
        }

        public T set(int index, T element) {
            checkIndex(index);
            return null;
        }

        public void add(int index, T element) {
            checkIndex(index);
            mas.add(index, element);
        }

        public boolean remove(Object o) {
            return mas.remove(o);
        }

        public T remove(int index) {
            checkIndex(index);
            return mas.remove(index);
        }

        public int indexOf(Object o) {
            return mas.indexOf(o);
        }

        public int lastIndexOf(Object o) {
            return mas.lastIndexOf(o);
        }
    }

    @Override
    public String toString() {
        return "\nStack{" +
                "stack=" + stack +
                 ", stack`s size=" + stack.size()+
                ", stackSize=" + stackSize +
                '}';
    }
}
