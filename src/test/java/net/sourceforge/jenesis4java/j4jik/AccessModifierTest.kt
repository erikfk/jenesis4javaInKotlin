package net.sourceforge.jenesis4java.j4jik

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class AccessModifierTest {
    @Test
    fun test() {
        assertEquals("", AccessModifier.PACKAGE.keyword())
        assertEquals("private", AccessModifier.PRIVATE.keyword())
        assertEquals("protected", AccessModifier.PROTECTED.keyword())
        assertEquals("public", AccessModifier.PUBLIC.keyword())
    }
}