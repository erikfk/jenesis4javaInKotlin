package net.sourceforge.jenesis4java.j4jik

/**
 * Models a typed argument wildcard.
 * See JLS 10 §4.5.1
 *
 * @param[type] type of wildcard bounds `extends` or `super`
 * @param[referenceType] reference type of wildcard bounds.
 */
class JWildcard private constructor(val type: JKeywords, val referenceType: String) {
    /**
     * Offers factory methods to create sensible [JWildcard] instances.
     */
    companion object {
        /**
         * Creates a wildcard declaration with extends, e.g.
         * `? extends ReferenceType`
         */
        fun extends(referenceType: String): JWildcard {
            return JWildcard(JKeywords.EXTENDS, referenceType)
        }
    }
}