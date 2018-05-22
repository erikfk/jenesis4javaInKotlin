package net.sourceforge.jenesis4java.j4jik

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class JWildcardBoundsTest {

    @Test
    fun wildcardBoundsExtends() {
        val wildcardBounds = JWildcardBounds.extends("SomeClass")
        assertSame(JKeywords.EXTENDS, wildcardBounds.type)
        assertEquals("SomeClass", wildcardBounds.referenceType)
    }

    @Test
    fun wildcardBoundsSuper() {
        val wildcardBounds = JWildcardBounds.jSuper("SomeClass")
        assertSame(JKeywords.SUPER, wildcardBounds.type)
        assertEquals("SomeClass", wildcardBounds.referenceType)
    }
}