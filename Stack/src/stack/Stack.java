package stack;

public interface Stack {
    boolean isEmpty();

    int getSize();

    void push(int element);

    int pop();

    int top();

    Integer find(int element);

    class IllegalCapacity extends RuntimeException {
    }

    class Empty extends RuntimeException {
    }

    // Remember to extend always RuntimeException
    class Overflow extends RuntimeException {
    }

    // Remember to extend always RuntimeException
    class Underflow extends RuntimeException {
    }

}
