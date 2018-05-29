package net.sourceforge.jenesis4java.j4jik

import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import net.sourceforge.jenesis4java.j4jik.InterfaceModifierKeyword.*

internal class InterfaceModifiersTest {
    val interfaceModifiers = InterfaceModifiers()

    @BeforeEach
    fun beforeEach() {
    }

    @Test
    fun getAnnotation() {
        assertEquals(0, interfaceModifiers.annotationsCount())
    }

    @Test
    fun setAnnotation() {
        interfaceModifiers.add(NormalAnnotation("AnnotationName"))

        assertTrue(interfaceModifiers.contains(NormalAnnotation("AnnotationName")))
    }

    @Test
    fun getModifierKeywordsInitial() {
        assertTrue(interfaceModifiers.modifierKeywords.isEmpty())
    }

    @Test
    fun getModifierKeywords() {
        interfaceModifiers.modifierKeywords.add(ABSTRACT)
        assertTrue(interfaceModifiers.modifierKeywords.contains(ABSTRACT))
    }
}