package net.sourceforge.jenesis4java.j4jik

/**
 * Models a normal annotation.
 *
 * See JLS 10 §9.7.1
 *
 * @param[typeName] name of the annotation
 */
class NormalAnnotation(val typeName: String) : Annotation {
    /**
     * Equals as usual.
     */
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as NormalAnnotation

        if (typeName != other.typeName) return false

        return true
    }

    /**
     * Hash code as usual
     */
    override fun hashCode(): Int {
        return typeName.hashCode()
    }

    /**
     * Writes the code of this annotation into [builder]
     */
    override fun toCode(builder: StringBuilder): StringBuilder {
        return builder.append("@$typeName")
    }
}