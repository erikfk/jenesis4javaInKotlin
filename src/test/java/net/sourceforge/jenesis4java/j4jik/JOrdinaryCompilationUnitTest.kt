package net.sourceforge.jenesis4java.j4jik

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class JOrdinaryCompilationUnitTest {

    @Test
    fun testToString() {
        val compilationUnit = JOrdinaryCompilationUnit("/some/path", "a.b.c")
        val toString = compilationUnit.toString()

        // Only check that the relevant data are provided
        // We don't care about the details of the String
        assertTrue(toString.indexOf("/some/path") >= 0)
        assertTrue(toString.indexOf("a.b.c") >= 0)
    }

    @Test
    fun getPath() {
        val compilationUnit = JOrdinaryCompilationUnit("/some/path", "a.b.c")

        assertEquals("a.b.c", compilationUnit.jPackage)
    }

    @Test
    fun getJPackage() {
        val compilationUnit = JOrdinaryCompilationUnit("/some/path", "a.b.c")

        assertEquals("/some/path", compilationUnit.path)
    }

    @Test
    fun imports() {
        val compilationUnit = JOrdinaryCompilationUnit("/some/path", "a.b.c")

        compilationUnit.addImport(Import("a.b.d"))

        val imports = compilationUnit.getImports()

        assertEquals(1, imports.size)
        assertEquals(Import("a.b.d"), imports[0])
    }
}