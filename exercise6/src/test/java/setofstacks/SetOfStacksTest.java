package setofstacks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SetOfStacksTest {

    private int stackSize = 10, setSize = 10;
    private SetOfStacks<Integer> setOfStacks;

    @BeforeEach
    public void init() {
        setOfStacks = new SetOfStacks<>(stackSize, setSize);
    }

    @Test
    void overflowSet() {
        int data = 10;
        boolean error = true;
        try {
            while (true) {
                setOfStacks.push(data);
            }
        } catch (ArrayStoreException e) {
            error = false;
        }

        if (error) {
            fail();
        }
    }

    @Test
    void pushAndPop() {
        int data = 10;
        setOfStacks.push(data);
        assertEquals(data, setOfStacks.pop());
    }

    @Test
    void overPop() {
        assertEquals(null, setOfStacks.pop());
    }

    @Test
    void popAt() {
//        setOfStacks.popAt(3);
    }

    @Test
    void overPopAt() {
        assertEquals(null, setOfStacks.popAt(stackSize-1));
        assertEquals(null, setOfStacks.popAt(stackSize-2));
        assertEquals(null, setOfStacks.popAt(stackSize-3));
    }

    @Test
    void popAtWithWrongIndex() {
        boolean error = true;
        try {
            while (true) {
                setOfStacks.popAt(stackSize);
            }
        } catch (IndexOutOfBoundsException e) {
            error = false;
        }

        if (error) {
            fail();
        }
    }
}