package net.sourceforge.jenesis4java.j4jik

/**
 * Defines Java keywords that are used in various contexts.
 * It's not yet clear if that the right way to handle the issue of Java keywords
 * - that should not be handled as Strings all over the place I think.
 *
 *  @param[keyword] the text of the Java keyword.
 * @constructor creates a new Java keyword enum with its texts
 */
enum class JKeywords(val keyword: String) {
    /**
     * Java class keyword.
     */
    CLASS("class"),
    /**
     * Java enum keyword.
     */
    ENUM("enum"),
    /**
     * Java extends keyword.
     */
    EXTENDS("extends"),
    /**
     * Java extends keyword.
     */
    SUPER("super")
}