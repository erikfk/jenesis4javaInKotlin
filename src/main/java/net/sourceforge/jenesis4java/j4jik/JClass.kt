package net.sourceforge.jenesis4java.j4jik

/**
 * Models a Java class.
 *
 * Note: without any content for now.
 *
 * @param[className] the name of the class to create
 * @constructor create a public class called [className]
 */
class JClass(val className : String) : Codeable {
    /**
     * Access modifier for class
     */
    var access = AccessModifier.PUBLIC

    /**
     * Writes the code of this class into [builder]
     */
    override fun toCode(builder: StringBuilder): StringBuilder {
        return builder.append("""
            |${access.value} ${JKeywords.CLASS.keyword} $className {
            |}
            """.trimMargin())
    }
}