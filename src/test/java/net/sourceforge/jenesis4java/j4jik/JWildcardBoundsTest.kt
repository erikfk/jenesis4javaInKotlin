package net.sourceforge.jenesis4java.j4jik

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class JWildcardBoundsTest {

    @Test
    fun testWildcardBoundsExtends() {
        val wildcardBounds = JWildcardBounds.extends("SomeClass")
        assertSame(JKeywords.EXTENDS, wildcardBounds.type)
        assertEquals("SomeClass", wildcardBounds.referenceType)
    }

    @Test
    fun testWildcardBoundsSuper() {
        val wildcardBounds = JWildcardBounds.jSuper("SomeClass")
        assertSame(JKeywords.SUPER, wildcardBounds.type)
        assertEquals("SomeClass", wildcardBounds.referenceType)
    }

    @Test
    fun testToCodeExtendsBounds() {
        assertEquals(" extends SomeClass", JWildcardBounds.extends("SomeClass").toCode())
    }

    @Test
    fun testToCodeSuperBounds() {
        assertEquals(" super SomeClass", JWildcardBounds.jSuper("SomeClass").toCode())
    }
}