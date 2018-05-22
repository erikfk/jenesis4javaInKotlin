package net.sourceforge.jenesis4java.j4jik

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class JWildcardTest {

    @Test
    fun wildcardWithBounds() {
        val wildcardBounds = JWildcardBounds.extends("SomeClass")
        val wildcard = JWildcard(wildcardBounds)
        assertSame(wildcardBounds, wildcard.wildcardBounds)
    }

    @Test
    fun wildcardWithoutBounds() {
        val wildcard = JWildcard()
        assertNull( wildcard.wildcardBounds)
    }

    @Test
    fun toCodedWithoutBounds() {
        assertEquals("?", JWildcard().toCode())
    }

    @Test
    fun toCodedWithBounds() {
        assertEquals("? extends SomeClass", JWildcard(JWildcardBounds.extends("SomeClass")).toCode())
    }
}