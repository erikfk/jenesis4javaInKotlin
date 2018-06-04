package net.sourceforge.jenesis4java.j4jik

/**
 * Models an annotation type declaration,
 *
 * See JSL 10 §9.6
 *
 * @param[typeIdentifier] name of the new annotation type
 */
class AnnotationDeclaration(val typeIdentifier : String) : Codeable {
    var modifiers: InterfaceModifiers? = null

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