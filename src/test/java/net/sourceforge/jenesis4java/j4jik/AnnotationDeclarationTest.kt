package net.sourceforge.jenesis4java.j4jik

import net.sourceforge.jenesis4java.j4jik.FormattingHelper.assertCodeEquals
import net.sourceforge.jenesis4java.j4jik.InterfaceModifier.*
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Nested

internal class AnnotationDeclarationTest {

    @Test
    fun getTypeIdentifier() {
        val annotationDeclaration = AnnotationDeclaration("AnnotationName")

        assertEquals("AnnotationName", annotationDeclaration.typeIdentifier)
    }

    @Nested
    inner class ToCodeTests {
        @Test
        fun simplestToCode() {
            val annotationDeclaration = AnnotationDeclaration("AnnotationName")

            assertCodeEquals("@interface AnnotationName {}", annotationDeclaration.toCode())
        }

        @Test
        fun testToCodeWithModifiers() {
            val annotationDeclaration = AnnotationDeclaration("AnnotationName")
            annotationDeclaration.add(InterfaceModifiers().add(PUBLIC))

            assertCodeEquals("public @interface AnnotationName {}", annotationDeclaration.toCode())
        }
    }
}