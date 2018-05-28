package net.sourceforge.jenesis4java.j4jik

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class NormalAnnotationTest {

    @Test
    fun getTypeName() {
        val normalAnnotation = NormalAnnotation("AnnotationName")

        assertEquals("AnnotationName", normalAnnotation.typeName)
    }

    @Test
    fun simplestToCode() {
        val normalAnnotation = NormalAnnotation("AnnotationName")

        assertEquals("@AnnotationName", normalAnnotation.toCode())
    }
}