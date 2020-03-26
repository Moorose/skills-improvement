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
        for (int i = 0; i < setSize * stackSize; i++) {
            setOfStacks.push(i);
        }
        for (int i = 0; i < setSize * stackSize; i++) {
            assertNotEquals(null, setOfStacks.pop());
        }
    }

    @Test
    void popEmptySet() {
        assertEquals(null, setOfStacks.pop());
    }

    @Test
    void popAt() {
        for (int i = 0; i < setSize * stackSize; i++) {
            setOfStacks.push(i);
        }
        assertEquals(stackSize * (setSize - 3) - 1, setOfStacks.popAt(setSize - 4));
        assertEquals(stackSize * (setSize - 3), setOfStacks.popAt(setSize - 4));
    }

    @Test
    void popAtEmptySet() {
        assertEquals(null, setOfStacks.popAt(stackSize - 1));
        assertEquals(null, setOfStacks.popAt(stackSize - 2));
        assertEquals(null, setOfStacks.popAt(stackSize - 3));
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