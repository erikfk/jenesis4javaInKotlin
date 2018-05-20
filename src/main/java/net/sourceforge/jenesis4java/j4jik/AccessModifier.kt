package net.sourceforge.jenesis4java.j4jik

/**
 * Models Java access modifiers.
 *
 * @param[value] the string for the access modifier in Java.
 */
enum class AccessModifier(val value : String) {
    /**
     * Package visible
     */
    PACKAGE(""),
    /**
     * Private access modifier
     */
    PRIVATE("private"),
    /**
     * protected access modifier
     */
    PROTECTED("protected"),
    /**
     * public access modifier
     */
    PUBLIC("public")
}