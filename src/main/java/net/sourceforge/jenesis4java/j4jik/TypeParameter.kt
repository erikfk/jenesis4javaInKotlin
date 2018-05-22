package net.sourceforge.jenesis4java.j4jik

/**
 * Models a Java type parameter.
 * See JLS 10 §8.1.2
 *
 * @param[typeIdentifier]
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
}