package net.sourceforge.jenesis4java.j4jik

/**
 * Models valid interface modifiers.
 *
 * See JLS 10 §9.1.1
 *
 * @param[value] string for the interface modified in Java.
 * @param[order] order in which the enum elements are meant to displayed. Lower
 * values come first, identical values overwrite each other.
 */
enum class InterfaceModifier(private val value : String, val order: Int) {
    /**
     * Java private keyword
     */
    PRIVATE("private", 1),
    /**
     * Java protected keyword
     */
    PROTECTED("protected", 1),
    /**
     * Java public keyword
     */
    PUBLIC("public", 1),
    /**
     * Java static keyword
     */
    STATIC("static", 2),
    /**
     * Java strictfp keyword
     */
    STRICTFP("strictfp", 3);


    /**
     * Return the Java keyword the [InterfaceModifier] represents as a [String]
     */
    fun keyword() : String {
        return value
    }
}