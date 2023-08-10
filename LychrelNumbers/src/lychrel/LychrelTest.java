package lychrel;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LychrelTest {

    private final int LIMIT = 1000;

    @Test
    public void facts(){
        convergesAtIteration(1, 0);
        convergesAtIteration(2, 0);
        convergesAtIteration(10, 1);
        convergesAtIteration(11, 0);
    }

    private void convergesAtIteration(int number, int iteration) {
        assertEquals(iteration, Lychrel.convergesAtIteration(number, LIMIT));
    }
}
