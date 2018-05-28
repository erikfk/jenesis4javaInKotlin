package net.sourceforge.jenesis4java.j4jik

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class AnnotationDeclarationTest {

    @Test
    fun getTypeIdentifier() {
        val annotationDeclaration = AnnotationDeclaration("AnnotationName")

        assertEquals("AnnotationName", annotationDeclaration.typeIdentifier)
    }

    @Test
    fun simplestToCode() {
        val annotationDeclaration = AnnotationDeclaration("AnnotationName")

        FormattingHelper.assertCodeEquals("@interface AnnotationName {}", annotationDeclaration.toCode())
        FormattingHelper.assertCodeEquals("@interface AnnotationName {}", annotationDeclaration.toCode())
    }
}