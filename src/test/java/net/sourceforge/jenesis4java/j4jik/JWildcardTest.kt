package net.sourceforge.jenesis4java.j4jik

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class JWildcardTest {

    @Test
    fun wildcardWithExtends() {
        val wildcard = JWildcard.extends("String")
        assertSame(JKeywords.EXTENDS, wildcard.type)
        assertEquals("String", wildcard.referenceType)
    }
}