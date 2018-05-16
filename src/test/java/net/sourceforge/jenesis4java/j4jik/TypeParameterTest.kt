package net.sourceforge.jenesis4java.j4jik

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class TypeParameterTest {
    @Test
    fun test() {
        assertEquals("E", TypeParameter("E").typeIdentifier)
    }
}