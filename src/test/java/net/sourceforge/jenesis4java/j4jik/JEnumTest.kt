package net.sourceforge.jenesis4java.j4jik

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class JEnumTest {
    @Test
    fun testCreateNewEnum() {
        val enum = JEnum("EnumName")

        assertEquals("EnumName", enum.enumName)
    }

    @Test
    fun testToCode() {
        FormattingHelper.assertCodeEquals("public enum EnumName {}", JEnum("EnumName").toCode())
    }
}