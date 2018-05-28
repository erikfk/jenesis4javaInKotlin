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
     * Writes the code of this annotation into [builder]
     */
    override fun toCode(builder: StringBuilder): StringBuilder {
        return builder.append("@$typeName")
    }
}