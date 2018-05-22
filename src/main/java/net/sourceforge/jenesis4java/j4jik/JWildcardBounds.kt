package net.sourceforge.jenesis4java.j4jik

/**
 * Models a typed argument wildcard bounds.
 * See JLS 10 §4.5.1
 *
 * @param[type] type of wildcard bounds `extends` or `super`
 * @param[referenceType] reference type of wildcard bounds.
 */
class JWildcardBounds private constructor (val type: JKeywords, val referenceType: String)  : Codeable {
    /**
     * Writes the code of this wildcard into [builder]
     */
    override fun toCode(builder: StringBuilder): StringBuilder {
        return builder.append(" ${type.keyword} $referenceType")
    }

    /**
     * Offers factory methods to create sensible [JWildcard] instances.
     */
    companion object {
        /**
         * Creates a wildcard declaration with extends, e.g.
         * `? extends ReferenceType`
         */
        fun extends(referenceType: String): JWildcardBounds {
            return JWildcardBounds(JKeywords.EXTENDS, referenceType)
        }
        /**
         * Creates a wildcard declaration with extends, e.g.
         * `? extends ReferenceType`
         */
        fun jSuper(referenceType: String): JWildcardBounds {
            return JWildcardBounds(JKeywords.SUPER, referenceType)
        }
    }
}