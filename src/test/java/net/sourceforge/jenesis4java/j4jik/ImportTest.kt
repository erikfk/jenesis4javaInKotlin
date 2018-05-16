package net.sourceforge.jenesis4java.j4jik

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class ImportTest {

    @Test
    fun testImport() {
        val import = Import("a.b.c")

        assertEquals("a.b.c", import.import)
    }

    @Test
    fun testToString() {
        val import = Import("a.b.c")

        val toString = import.toString()
        assertTrue(toString.contains("a.b.c"), "Expected toString to contain the name of the import but was $toString")
    }

    @Test
    fun testEqualsHashCodeDifferent() {
        val import = Import("a.b.c")
        val import2 = Import("a.b.f")

        assertNotEquals(import, import2)
    }

    @Test
    fun testEqualsHashCodeSame() {
        val import = Import("a.b.c")

        assertEquals(import, import)
        assertEquals(import.hashCode(), import.hashCode())
    }

    @Test
    fun testEqualsHashCodeEquals() {
        val import = Import("a.b.c")

        assertEquals(import, import)

        val import2 = Import("a.b.c")

        assertEquals(import, import2)
        assertEquals(import2, import)
        assertEquals(import.hashCode(), import2.hashCode())
    }
}

