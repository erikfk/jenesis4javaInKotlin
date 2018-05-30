package net.sourceforge.jenesis4java.j4jik

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import net.sourceforge.jenesis4java.j4jik.InterfaceModifierKeyword.*

internal class InterfaceModifiersTest {
    private val interfaceModifiers = InterfaceModifiers()

    @Test
    fun testNoAnnotationInNewInstance() {
        assertEquals(0, interfaceModifiers.annotationsCount())
    }

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
    fun testNoModifierInNewInstance() {
        assertEquals(0, interfaceModifiers.modifierKeywordsCount())
    }

    @Test
    fun testAddModifierKeywords() {
        interfaceModifiers.add(ABSTRACT)

        assertTrue(interfaceModifiers.contains(ABSTRACT))
        assertEquals(1, interfaceModifiers.modifierKeywordsCount())

        interfaceModifiers.add(ABSTRACT)
        assertEquals(1, interfaceModifiers.modifierKeywordsCount())

        interfaceModifiers.add(STATIC)
        assertEquals(2, interfaceModifiers.modifierKeywordsCount())
    }
}