package net.sourceforge.jenesis4java.j4jik

import net.sourceforge.jenesis4java.j4jik.FormattingHelper.assertCodeEquals
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class JClassTest {
    @Test
    fun getClassName() {
        assertEquals("ClassName", JClass("ClassName").className)
    }

    @Test
    fun toCode() {
        assertCodeEquals("public class ClassName {}", JClass("ClassName").toCode())
    }

    @Test
    fun access() {
        val jClass = JClass("ClassName")
        jClass.access = AccessModifier.PRIVATE

        assertEquals(AccessModifier.PRIVATE, jClass.access)
    }

    @Test
    fun toCodePrivate() {
        val jClass = JClass("ClassName")
        jClass.access = AccessModifier.PRIVATE


        assertCodeEquals("private class ClassName {}", jClass.toCode())
    }
}