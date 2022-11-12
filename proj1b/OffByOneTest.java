import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class OffByOneTest {

    static OffByOne offByOne = new OffByOne();

    @Test
    public void TestEqualChars() {
        assertTrue(offByOne.equalChars('r', 'q'));
        assertFalse(offByOne.equalChars('a', 'z'));
    }
}
