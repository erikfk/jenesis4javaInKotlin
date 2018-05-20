package net.sourceforge.jenesis4java.j4jik

/**
 * Models a Java class.
 *
 * Note: without any content for now.
 *
 * @param[className] the name of the class to create
 * @constructor create a public class called [className]
 */
class JClass(val className : String) {
    /**
     * Access modifier for class
     */
    var access = AccessModifier.PUBLIC

    /**
     * Write the code of this class into [builder]
     */
    fun toCode(builder: StringBuilder): StringBuilder {
        return builder.append("""
            |${access.value} class $className {
            |}
            """.trimMargin())
    }
}