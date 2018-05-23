package net.sourceforge.jenesis4java.j4jik

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class TypeParameterTest {
    @Test
    fun test() {
        assertEquals("E", TypeParameter("E").typeIdentifier)
    }

    @Test
    fun tesCodeSimpleTypeIdentifier() {
        assertEquals("E", TypeParameter("E").toCode())
    }

    @Test
    fun testCodeWithExtends() {
        assertEquals("E extends F", TypeParameter("E").extendBound("F").toCode())
    }

    @Test
    fun testEqualsWhenSame() {
        val typeParameter = TypeParameter("E").extendBound("F")
        assertEquals(typeParameter, typeParameter)
    }

    @Test
    fun tesHashCodeWithBound() {
        val typeParameter = TypeParameter("E").extendBound("F")
        assertEquals(typeParameter.hashCode(), typeParameter.hashCode())
    }

    @Test
    fun tesHashCode() {
        val typeParameter = TypeParameter("E")
        assertEquals(typeParameter.hashCode(), typeParameter.hashCode())
    }

    @Test
    fun testEquals() {
        assertEquals(TypeParameter("E").extendBound("F"), TypeParameter("E").extendBound("F"))
    }

    @Test
    fun testEqualsNull() {
        assertNotEquals(TypeParameter("E").extendBound("F"), null)
    }

    @Test
    fun testEqualsDifferentTypes() {
        assertNotEquals(TypeParameter("E"), "")
    }

    @Test
    fun testEqualsWhenDifferent() {
        assertNotEquals(TypeParameter("E"), TypeParameter("F"))
        assertNotEquals(TypeParameter("E").extendBound("F"), TypeParameter("E").extendBound("G"))
    }

    @Test
    fun testToString() {
        val typeParameter = TypeParameter("SomeClass").extendBound("SomeOtherClass")
        val string = typeParameter.toString()

        assertTrue(string.contains("SomeClass") && string.contains("extends")  && string.contains("SomeOtherClass") ,
                "Expected toString to provide the relevant information but was $string")
    }
}