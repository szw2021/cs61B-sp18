import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {

    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testIsPalindrome() {
        assertFalse(palindrome.isPalindrome("cat"));
        assertTrue(palindrome.isPalindrome("a"));
        assertTrue(palindrome.isPalindrome("racecar"));
    }

    @Test
    public void testIsPalindromeOffByOne() {
        assertFalse(palindrome.isPalindrome("cat", new OffByOne()));
        assertTrue(palindrome.isPalindrome("a", new OffByOne()));
        assertFalse(palindrome.isPalindrome("racecar", new OffByOne()));
        assertTrue(palindrome.isPalindrome("flake", new OffByOne()));
    }
}
