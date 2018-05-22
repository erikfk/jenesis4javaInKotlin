package net.sourceforge.jenesis4java.j4jik

/**
 * Models objects capable of generating code.
 */
interface Codeable {
    /**
     * Writes the code of the [Codeable] into the specidied [builder]
     */
    fun toCode(builder: StringBuilder): StringBuilder

    /**
     * Returns the code of the [Codeable] as a [String]
     */
    fun toCode() : String {
        return toCode(StringBuilder()).toString()
    }
}