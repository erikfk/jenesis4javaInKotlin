package net.sourceforge.jenesis4java.j4jik

/**
 * Models an annotation type declaration,
 *
 * See JSL 10 §9.6
 *
 * @param[typeIdentifier] name of the new annotation type
 */
class AnnotationDeclaration(val typeIdentifier : String) : Codeable {
    override fun toCode(builder: StringBuilder): StringBuilder {
        return builder.append("@interface $typeIdentifier { }")
    }
}