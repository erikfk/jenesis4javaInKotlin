package net.sourceforge.jenesis4java.j4jik

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertSame

internal class ElementValuePairTest {
    @Test
    fun basicTest() {
        val elementValue = NormalAnnotation("AnAnnotation")
        val pair = ElementValuePair("Identifier", elementValue)

        assertEquals("Identifier", pair.identifier)
        assertSame(elementValue, pair.elementValue)
    }
}