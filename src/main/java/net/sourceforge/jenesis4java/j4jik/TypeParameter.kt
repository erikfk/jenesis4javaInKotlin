package net.sourceforge.jenesis4java.j4jik

/**
 * Models a Java type parameter.
 * See JLS 10 §8.1.2
 *
 * @param[typeIdentifier] the type identifier of the [TypeParameter]
 */
class TypeParameter(val typeIdentifier : String) : Codeable {
    private var typeBound: String? = null

    /**
     * Writes the code of this class into [builder] and returns [builder].
     */
    override fun toCode(builder: StringBuilder): StringBuilder {
        builder.append(typeIdentifier)
        if (typeBound != null) {
            builder.append(" extends $typeBound")
        }
        return builder
    }

    /**
     * Adds the extends bound [bound] to this type parameter and returns this
     * [TypeParameter].
     */
    fun extendBound(bound: String): TypeParameter {
        this.typeBound = bound
        return this
    }

    /**
     * Checks equality as one would expect
     */
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as TypeParameter

        if (typeIdentifier != other.typeIdentifier) return false
        if (typeBound != other.typeBound) return false

        return true
    }

    /**
     * Returns the hash code.
     */
    override fun hashCode(): Int {
        var result = typeIdentifier.hashCode()
        result = 31 * result + (typeBound?.hashCode() ?: 0)
        return result
    }

    /**
     * Human readable representation of this [TypeParameter]
     */
    override fun toString(): String {
        return "TypeParameter(${toCode()})"
    }
}