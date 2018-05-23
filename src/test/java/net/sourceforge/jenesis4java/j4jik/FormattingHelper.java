package net.sourceforge.jenesis4java.j4jik;

import com.google.googlejavaformat.java.Formatter;
import com.google.googlejavaformat.java.FormatterException;
import org.junit.jupiter.api.Assertions;

/**
 * Formats Java code in a standard way, making it easier to compare generated
 * code with expected code.
 * For now we use the Google formatter that seems to meet the needs. We may
 * have to use another formatter later on if the Google formatter is too
 * opinionated about how it handles certain code and this interferes with our
 * purpose.
 * <p>
 * Note that this needs not to be a Java class. It was made a Java class to
 * see how Java and Kotlin class interact with each other - later on this may
 * be turned into a Kotlin class.
 */
public class FormattingHelper {
    private final static Formatter FORMATTER = new Formatter();

    /**
     * Returns the specified code as formatted code.
     *
     * @param rawCode the code to format
     * @return the formatted code
     * @throws FormatterException thrown if formatting failed (typically because
     *                            the code is incorrect).
     */
    public static String formatCode(String rawCode) {
        try {
            return FORMATTER.formatSource(rawCode);
        } catch (FormatterException e) {
            Assertions.fail("Unable to format " + rawCode, e);
            return "";
        }
    }

    /**
     * Verifies that the expected code is equal to the actual code, after both
     * have been formatted.
     *
     * @param expectedCode the (possibly) unformatted expected code
     * @param actualCode   the (possibly) unformatted actual code
     * @throws FormatterException thrown if formatting failed (typically because
     *                            the code is incorrect).
     */
    public static void assertCodeEquals(String expectedCode, String actualCode) throws FormatterException {
        Assertions.assertEquals(formatCode(expectedCode), formatCode(actualCode));
    }
}
