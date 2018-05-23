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

    @Test
    fun getTypeParameterWhenNone() {
        val jClass = JClass("ClassName")

        assertEquals(0, jClass.getTypeParameters().size)
    }

    @Test
    fun addTypeParameter() {
        val jClass = JClass("ClassName")
        jClass.addTypeParameter(TypeParameter("E"))

        val typeParameters = jClass.getTypeParameters()

        assertEquals(1, typeParameters.size)
        assertEquals(TypeParameter("E"), typeParameters[0])
    }

    @Test
    fun toCodeWithOneTypeParameter() {
        val jClass = JClass("ClassName")
        jClass.addTypeParameter(TypeParameter("E"))

        assertCodeEquals("public class ClassName<E> {}", jClass.toCode())
    }

    @Test
    fun toCodeWithTypeParameters() {
        val jClass = JClass("ClassName")
        jClass.addTypeParameter(TypeParameter("E"))
        jClass.addTypeParameter(TypeParameter("F").extendBound("G"))

        assertCodeEquals("public class ClassName<E, F extends G> {}", jClass.toCode())
    }
}