package net.sourceforge.jenesis4java.j4jik

/**
 * Models a typed argument wildcard.
 * See JLS 10 §4.5.1
 */
class JWildcard private constructor(val type: JKeywords, val referenceType: String) {
    /**
     * Offers factory methods to create sensible [JWildcard] instances.
     */
    companion object {
        fun extends(referenceType: String): JWildcard {
            return JWildcard(JKeywords.EXTENDS, referenceType)
        }
    }
}