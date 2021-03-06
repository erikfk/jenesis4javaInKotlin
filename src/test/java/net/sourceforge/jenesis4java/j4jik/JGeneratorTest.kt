package net.sourceforge.jenesis4java.j4jik

import net.sourceforge.jenesis4java.j4jik.JGenerator.createOrdinaryCompilationUnit
import net.sourceforge.jenesis4java.j4jik.JGenerator.getUnits
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class JGeneratorTest {
    @Test
    fun testOrdinaryCompilationUnitCreation() {
        val unit = createOrdinaryCompilationUnit("path/to/fileCreate", "net.sourceforge.jenesis4java.j4jik")

        assertEquals("path/to/fileCreate", unit.path)
        assertEquals("net.sourceforge.jenesis4java.j4jik", unit.jPackage)
    }

    @Test
    fun testOrdinaryCompilationUnitCreationBasePackage() {
        val unit = createOrdinaryCompilationUnit("path/to/fileCreateInBase")

        assertEquals("path/to/fileCreateInBase", unit.path)
        assertEquals("", unit.jPackage)
    }

    @Test
    fun testClear() {
        createOrdinaryCompilationUnit("path/to/fileClear", "net.sourceforge.jenesis4java.j4jik")
        JGenerator.clear()

        assertEquals(0, getUnits().size)
    }

    @Test
    fun testGetUnits() {
        var units = getUnits()
        assertEquals(0, units.size, "There should be no unit but found $units")
        assertListIsUnmodifiable(units)

        for (i in 1..10) {
            createOrdinaryCompilationUnit("path/to/file$i", "net.sourceforge.jenesis4java.j4jik")
            units = getUnits()

            assertEquals(i, units.size)
            assertListIsUnmodifiable(units)
        }
    }

    // Silly way to verify the returned list cannot be used to modify JGenerator
    // See if this can be simplified or should be removed.
    private fun assertListIsUnmodifiable(units: List<JOrdinaryCompilationUnit>) {
        val initialSize = getUnits().size
        try {
            when (units) {
                is MutableList -> {
                    units.add(JOrdinaryCompilationUnit("path"))
                    checkSizeUnchanged(initialSize)
                }
                is java.util.List<*> -> {
                    val unitsList = units as java.util.List<JOrdinaryCompilationUnit>
                    unitsList.add(JOrdinaryCompilationUnit("path"))
                    checkSizeUnchanged(initialSize)
                }
                else -> fail("unexpected list type")
            }
        } catch (e: UnsupportedOperationException) {
            // is OK as it means that the
        }
    }

    private fun checkSizeUnchanged(initialSize: Int) {
        if (initialSize != getUnits().size) {
            fail<Void>("We should not be able to modify the list in JGenerator")
        }
    }

    @BeforeEach
    fun beforeEach() {
        JGenerator.clear()
    }
}