package setofstacks;

import java.util.*;

public class Stack<T> {

    private BoundedList<T> stack;
    private int stackSize;

    public Stack(int size) {
        stack = new BoundedList<T>(size);
        stackSize = size;
    }

    public void push(T data) {      //   O (n)
        if (stack.size() < stackSize) {     //  O (1)
            stack.add(0, data);       // O (n)
            return;
        }
        throw new ArrayStoreException("Stack is full");
    }


    public T pop() {        //   O (n)
        T element = stack.get(0);   //  O (1)
        stack.remove(element);      //   O (n)
        return element;
    }

    public T removeBottom() {    //  O (n)
        T element = stack.get(stack.size()-1);   //  O (1)
        stack.remove(element);                   //  O (n)
        return element;
    }

    public boolean isEmpty() {    //    O (1)
        return stack.isEmpty();
    }

    public boolean isFull() {    //    O (1)
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

        private void checkIndex(int index) {    //    O (1)
            if (index > stackSize) {
                throw new IndexOutOfBoundsException();
            }
        }

        public int size() { //    O (1)
            return mas.size();
        }

        public boolean isEmpty() {  //    O (1)
            return mas.isEmpty();
        }

        public T get(int index) {   //  O (1)
            checkIndex(index);
            if (mas.size() <= index) {
                return null;
            }
            return mas.get(index);
        }



        public void add(int index, T element) { // O (n)
            checkIndex(index);
            mas.add(index, element);
        }

        public boolean remove(Object o) {   //   O (n)
            return mas.remove(o);
        }
    }

    @Override
    public String toString() {
        return "\nStack{" +
                "stack=" + stack +
                 ", stack fullness=" + stack.size()+
                ", stack capacity=" + stackSize +
                '}';
    }
}
