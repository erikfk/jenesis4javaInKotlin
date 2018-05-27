package net.sourceforge.jenesis4java.j4jik

/**
 * Models an enum type.
 *
 * @param[enumName] name of the enum type
 * @constructor creates a new public enum type named [enumName]
 */
class JEnum(val enumName: String) : Codeable {
    /**
     * Access modifier for enum type
     */
    var access = AccessModifier.PUBLIC

    /**
     * Writes the code of this class into [builder]
     */
    override fun toCode(builder: StringBuilder): StringBuilder {
        return builder.append("${access.value} ${JKeywords.ENUM.keyword}  $enumName {}")
    }
}