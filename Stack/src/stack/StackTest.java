package stack;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StackTest{

    private Stack stack;

    @Before
    public void setUp(){
        stack = BoundedStack.Make(2);
    }
    @Test
    public void newlyCreatedStack_ShouldBeEmpty(){
        assertTrue(stack.isEmpty());
        assertEquals(0, stack.getSize());
    }

    @Test
    public void afterOnePush_StackSizeShouldBeOne(){
        stack.push(1);

        assertEquals(1, stack.getSize());
        assertFalse(stack.isEmpty());
    }

    @Test
    public void afterOnePushAndOnePop_ShouldBeEmpty(){
        stack.push(1);
        stack.pop();
        assertTrue(stack.isEmpty());
    }

    @Test(expected = BoundedStack.Overflow.class)
    public void whenPushedPastLimit_StackOverflows(){
        stack.push(1);
        stack.push(1);
        stack.push(1);
    }

    @Test(expected = BoundedStack.Underflow.class)
    public void whenEmptyStackIsPopped_ShouldThrowUnderflow(){
        stack.pop();
    }

    @Test
    public void WhenOneIsPushed_OneIsPopped(){
        stack.push(1);

        assertEquals(1, stack.pop());
    }

    @Test
    public void whenOneAndTwoArePushed_TwoAndOneArePopped(){
        stack.push(1);
        stack.push(2);

        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());
    }

    @Test(expected = BoundedStack.IllegalCapacity.class)
    public void whenCreatingStackWithNegativeSize_ShouldThrowIllegalCapacity(){
        BoundedStack.Make(-1);
    }

    @Test(expected = BoundedStack.Overflow.class)
    public void whenCreatingStackWithZeroCapacity_AnyPushShouldOverflow(){
        stack = BoundedStack.Make(0);
        stack.push(1);
    }

    @Test
    public void whenOneIsPushed_OneIsOnTop(){
        stack.push(1);

        assertEquals(1, stack.top());
    }

    @Test(expected = Stack.Empty.class)
    public void whenStackIsEmpty_TopThrowsEmpty(){
        stack.top();
    }

    @Test(expected = Stack.Empty.class)
    public void whenZeroCapacityStack_topThrowsEmpty(){
        stack = BoundedStack.Make(0);

        stack.top();
    }

    @Test
    public void givenStackWithOneTwoPushed_findOneAndTwo(){
        stack.push(1);
        stack.push(2);

        // the top of the stack is at index 0
        assertEquals(1, stack.find(1).intValue());
        assertEquals(0, stack.find(2).intValue());
    }

    @Test
    public void givenStackWithOneTwoThreePushed_findOneAndTwoAndThree(){
        stack = BoundedStack.Make(3);
        stack.push(1);
        stack.push(2);
        stack.push(3);

        // the top of the stack is at index 0
        assertEquals(2, stack.find(1).intValue());
        assertEquals(1, stack.find(2).intValue());
        assertEquals(0, stack.find(3).intValue());
    }

    @Test
    public void givenStackWithNo2_find2ShouldReturnNull(){
        assertNull(stack.find(2));
    }
}
