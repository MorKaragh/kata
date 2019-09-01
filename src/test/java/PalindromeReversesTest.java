import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

class PalindromeReversesTest {

    @Test
    void reverses() {

        assertEquals(PalindromeReverses.reverses(0),0);
        assertEquals(PalindromeReverses.reverses(11),0);
        assertEquals(PalindromeReverses.reverses(47),1);
        assertEquals(PalindromeReverses.reverses(48),2);
        assertEquals(PalindromeReverses.reverses(2030665015),30);

        boolean wasException = false;
        try{
            assertEquals(PalindromeReverses.reverses(196),30);
        } catch (Exception e) {
            wasException = true;
        }
        assertTrue(wasException);

    }


    @Test
    void reverseNumber() {
        assertEquals(PalindromeReverses.reverseNumber(BigInteger.valueOf(12)),BigInteger.valueOf(21));
        assertEquals(PalindromeReverses.reverseNumber(BigInteger.valueOf(-12)),BigInteger.valueOf(-21));
    }
}