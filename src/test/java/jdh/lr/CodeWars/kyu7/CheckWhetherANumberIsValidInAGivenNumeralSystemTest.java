package jdh.lr.CodeWars.kyu7;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckWhetherANumberIsValidInAGivenNumeralSystemTest {
    private void doTest(String num, int base, boolean expected) {
        String messageOnFail = "Test failed for num = " + num + ", base = " + base + "\n\n";

        assertEquals(expected, CheckWhetherANumberIsValidInAGivenNumeralSystem.validateBase(num, base), messageOnFail);
    }

    @Test
    @DisplayName("Sample tests")
    void sampleTests() {
        doTest("61262", 8, true);
        doTest("ABCDEF", 16, true);
        doTest("25172", 5, false);
        doTest("EG", 16, false);
        doTest("W", 32, false);
        doTest("99235", 9, false);
        doTest("009", 10, true);
        doTest("0", 5, true);
    }
}