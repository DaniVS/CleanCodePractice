import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReplaceCharsTest {
    @Test
    public void basicTests() {
        assertEquals("Vader soid: No, I am your fother!", ReplaceChars.replaceNth("Vader said: No, I am your father!", 2, 'a', 'o'));
        assertEquals("Vader said: No, I am your fother!", ReplaceChars.replaceNth("Vader said: No, I am your father!", 4, 'a', 'o'));
        assertEquals("Vader said: No, I am your father!", ReplaceChars.replaceNth("Vader said: No, I am your father!", 6, 'a', 'o'));
        assertEquals("Vader said: No, I am your father!", ReplaceChars.replaceNth("Vader said: No, I am your father!", 0, 'a', 'o'));
        assertEquals("Vader said: No, I am your father!", ReplaceChars.replaceNth("Vader said: No, I am your father!", -2, 'a', 'o'));
        assertEquals("Vader sayd: No, I am your father!", ReplaceChars.replaceNth("Vader said: No, I am your father!", 1, 'i', 'y'));
        assertEquals("Vyder syid: No, I ym your fyther!", ReplaceChars.replaceNth("Vader said: No, I am your father!", 1, 'a', 'y'));

        assertEquals("Luke cries: Noooooioooooioooo!", ReplaceChars.replaceNth("Luke cries: Noooooooooooooooo!", 6, 'o', 'i'));
    }
}
