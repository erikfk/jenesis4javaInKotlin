package net.sourceforge.jenesis4java.j4jik

/**
 * Models one Java import declaration, For now we just store the string that
 * is provided in the constructor. Later on we'll add checking etc.
 *
 * @param[import] the import as a String
 * @constructor Creates an import
 */
class Import(val import: String) {
    /**
     *  Human readable representation of this [Import].
     */
    override fun toString(): String {
        return "Import(import='$import')"
    }

    /**
     * Checks equality as one would expect
     */
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Import

        if (import != other.import) return false

        return true
    }

    /**
     * Returns the hash code.
     */
    override fun hashCode(): Int {
        return import.hashCode()
    }
}