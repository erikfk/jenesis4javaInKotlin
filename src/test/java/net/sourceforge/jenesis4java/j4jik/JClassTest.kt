package net.sourceforge.jenesis4java.j4jik

import com.google.googlejavaformat.java.Formatter
import net.sourceforge.jenesis4java.j4jik.FormattingHelper.assertCodeEquals
import net.sourceforge.jenesis4java.j4jik.FormattingHelper.formatCode
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class JClassTest {
    val formatter = Formatter()

    @Test
    fun getClassName() {
        assertEquals("ClassName", JClass("ClassName").className)
    }

    @Test
    fun toCode() {
        val builder = StringBuilder()
        JClass("ClassName").toCode(builder)
        assertCodeEquals("public class ClassName {}", builder.toString())
    }

    @Test
    fun access() {
        val jClass = JClass("ClassName")
        jClass.access = AccessModifier.PRIVATE

        assertEquals(AccessModifier.PRIVATE, jClass.access)
    }

    @Test
    fun toCodePrivate() {
        val builder = StringBuilder()
        val jClass = JClass("ClassName")
        jClass.access = AccessModifier.PRIVATE
        jClass.toCode(builder)

        assertCodeEquals("private class ClassName {}", builder.toString())
    }
}