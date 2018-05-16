package net.sourceforge.jenesis4java.j4jik

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class AccessModifierTest {
    @Test
    fun test() {
        assertEquals("", AccessModifier.PACKAGE.value)
        assertEquals("private", AccessModifier.PRIVATE.value)
        assertEquals("protected", AccessModifier.PROTECTED.value)
        assertEquals("public", AccessModifier.PUBLIC.value)
    }
}