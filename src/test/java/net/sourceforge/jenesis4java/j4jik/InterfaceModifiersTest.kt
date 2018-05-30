package net.sourceforge.jenesis4java.j4jik

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import net.sourceforge.jenesis4java.j4jik.InterfaceModifierKeyword.*
import org.junit.jupiter.api.assertThrows

internal class InterfaceModifiersTest {
    private val interfaceModifiers = InterfaceModifiers()

    @Test
    fun testAddAnnotation() {
        interfaceModifiers.add(NormalAnnotation("FirstAnnotation"))

        assertEquals(1, interfaceModifiers.annotationsCount())
        assertTrue(interfaceModifiers.contains(NormalAnnotation("FirstAnnotation")))

        interfaceModifiers.add(NormalAnnotation("SecondAnnotation"))
        assertEquals(2, interfaceModifiers.annotationsCount())
        assertTrue(interfaceModifiers.contains(NormalAnnotation("FirstAnnotation")))
        assertTrue(interfaceModifiers.contains(NormalAnnotation("SecondAnnotation")))
    }

    @Test
    fun testAddModifierKeywords() {
        interfaceModifiers.add(PUBLIC)

        assertTrue(interfaceModifiers.contains(PUBLIC))
        assertEquals(1, interfaceModifiers.modifierKeywordsCount())

        interfaceModifiers.add(PUBLIC)
        assertEquals(1, interfaceModifiers.modifierKeywordsCount())

        interfaceModifiers.add(STATIC)
        assertEquals(2, interfaceModifiers.modifierKeywordsCount())
    }

    @Test
    fun testNoAnnotationInNewInstance() {
        assertEquals(0, interfaceModifiers.annotationsCount())
    }

    @Test
    fun testNoModifierInNewInstance() {
        assertEquals(0, interfaceModifiers.modifierKeywordsCount())
    }

    @Test
    fun testToCodeOnNewInstance() {
        assertEquals("", interfaceModifiers.toCode())
    }

    @Test
    fun testTryAddingDifferentAccessModifiers() {
        val illegalStateException = assertThrows<IllegalStateException> { interfaceModifiers.add(PUBLIC).add(PRIVATE) }

        assertTrue(
            illegalStateException.message!!.contains(PUBLIC.name),
            "Expected to find  \"${PUBLIC.name}\" in the exception message but message was\" ${illegalStateException.message}\""
        )
    }

    @Test
    fun testToCodeWithVariousModifiers() {
        interfaceModifiers.add(PUBLIC).add(STATIC).add(STRICTFP)
        assertEquals("public static strictfp", interfaceModifiers.toCode())
    }
}