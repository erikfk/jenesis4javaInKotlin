package net.sourceforge.jenesis4java.j4jik

/**
 * Models keywords valid in interface modifiers.
 *
 * See JLS 10 §9.1.1
 *
 * @param[value] string for the interface modified in Java.
 */
enum class InterfaceModifierKeyword(val value : String) {
    /**
     * Java private keyword
     */
    PRIVATE("private"),
    /**
     * Java protected keyword
     */
    PROTECTED("protected"),
    /**
     * Java public keyword
     */
    PUBLIC("public"),
    /**
     * Java static keyword
     */
    STATIC("static"),
    /**
     * Java strictfp keyword
     */
    STRICTFP("strictfp");
}