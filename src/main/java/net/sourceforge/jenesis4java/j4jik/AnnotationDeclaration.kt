package net.sourceforge.jenesis4java.j4jik

/**
 * Models an annotation type declaration,
 *
 * See JSL 10 §9.6
 *
 * Notes:
 * + Restrictions on the modifiers supported for annotation declarations
 * haven't yet been considered.
 * + AnnotationTypeBody is not yet supported.
 *
 * @param[typeIdentifier] name of the new annotation type
 */
class AnnotationDeclaration(val typeIdentifier : String) : Annotation {
    /**
     * [InterfaceModifiers] of the [AnnotationDeclaration]
     */
    var modifiers: InterfaceModifiers? = null

    /**
     * Adds the specified [modifiers] to this  [AnnotationDeclaration].
     *
     * Note that any previously defined modifiers are silently overwritten.
     */
    fun add(modifiers: InterfaceModifiers) {
        this.modifiers = modifiers
    }

    override fun toCode(builder: StringBuilder): StringBuilder {
        val initialLength = builder.length
        builder.append(modifiers?.toCode() ?: "")
        if (builder.length != initialLength) builder.append(" ")
        return builder.append("@interface $typeIdentifier { }")
    }
}