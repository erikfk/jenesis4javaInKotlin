package net.sourceforge.jenesis4java.j4jik

import net.sourceforge.jenesis4java.j4jik.JGenerator.createOrdinaryCompilationUnit
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class JGeneratorTest {
    @Test
    fun testOrdinaryCompilationUnitCreation() {
        val unit = createOrdinaryCompilationUnit("path/to/file", "net.sourceforge.jenesis4java.j4jik")
        assertEquals("path/to/file", unit.path)
        assertEquals("net.sourceforge.jenesis4java.j4jik", unit.jPackage)
    }
}