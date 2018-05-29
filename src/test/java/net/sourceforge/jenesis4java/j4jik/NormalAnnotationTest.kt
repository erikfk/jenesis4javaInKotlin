package net.sourceforge.jenesis4java.j4jik

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotEquals
import org.junit.jupiter.api.Test

internal class NormalAnnotationTest {

    @Test
    fun getTypeName() {
        val normalAnnotation = NormalAnnotation("AnnotationName")

        assertEquals("AnnotationName", normalAnnotation.typeName)
    }

    @Test
    fun testEqualsSame() {
        val normalAnnotation = NormalAnnotation("AnnotationName")

        assertEquals(normalAnnotation, normalAnnotation)
    }

    @Test
    fun testEquals() {
        assertEquals(NormalAnnotation("AnnotationName"), NormalAnnotation("AnnotationName"))
    }

    @Test
    fun testEqualsDifferent() {
        assertNotEquals(NormalAnnotation("Name"), NormalAnnotation("OtherName"))
    }

    @Test
    fun testEqualsDifferentTypes() {
        assertNotEquals(NormalAnnotation("AnnotationName"), "false")
    }

    @Test
    fun testEqualsNull() {
        assertNotEquals(NormalAnnotation("AnnotationName"), null)
    }

    @Test
    fun testHashCode() {
        assertEquals(NormalAnnotation("AnnotationName").hashCode(), NormalAnnotation("AnnotationName").hashCode())
    }

    @Test
    fun testSimplestToCode() {
        val normalAnnotation = NormalAnnotation("AnnotationName")

        assertEquals("@AnnotationName", normalAnnotation.toCode())
    }
}