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
        val build = StringBuilder()
        assertEquals("E", TypeParameter("E").toCode(build).toString())
    }

    @Test
    fun tesCodeWithExtends() {
        val build = StringBuilder()
        assertEquals("E extends F", TypeParameter("E").extendBound("F").toCode(build).toString())
    }
}