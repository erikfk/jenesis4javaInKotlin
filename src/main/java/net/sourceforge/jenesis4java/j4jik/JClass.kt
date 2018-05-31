package net.sourceforge.jenesis4java.j4jik

/**
 * Models a Java class.
 *
 * @param[className] the name of the class to create
 * @constructor creates a new public class named [className]
 */
class JClass(val className: String) : Codeable {
    /**
     * Access modifier for class
     */
    var access = AccessModifier.PUBLIC

    private val typeParameters = ArrayList<TypeParameter>()

    /**
     * Writes the code of this class into [builder]
     */
    override fun toCode(builder: StringBuilder): StringBuilder {
        return builder.append("""
            |${access.keyword()} ${JKeywords.CLASS.keyword} $className${typeParametersToCode()} {
            |}
            """.trimMargin())
    }

    private fun typeParametersToCode(): String {
        if (typeParameters.isEmpty()) return ""
        return "<${collectTypeParameterDeclaration()}>"
    }

    private fun collectTypeParameterDeclaration() = typeParameters.joinToString(transform = TypeParameter::toCode)

    /**
     * Adds [typeParameter] to this [JClass]'s type parameter list.
     */
    fun addTypeParameter(typeParameter: TypeParameter) {
        typeParameters.add(typeParameter)
    }

    /**
     * Returns a copy of this [JClass]'s  type parameter list.
     */
    fun getTypeParameters(): List<TypeParameter> {
        return typeParameters.toList()
    }
}