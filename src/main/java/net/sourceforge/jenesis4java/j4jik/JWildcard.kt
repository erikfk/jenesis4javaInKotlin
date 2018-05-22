package net.sourceforge.jenesis4java.j4jik

/**
 * Models a typed argument wildcard.
 * See JLS 10 §4.5.1
 */
class JWildcard : Codeable {
    /**
     * The possibly null [JWildcardBounds] of this [JWildcard]
     */
    val wildcardBounds: JWildcardBounds?

    /**
     * Creates a [JWildcard] without wildcard bounds - i.e. with `?`
     */
    constructor() {
        wildcardBounds = null
    }

    /**
     * Creates a [JWildcard] the specified  wildcard [wildcardBounds]
     */
    constructor(wildcardBounds: JWildcardBounds) {
        this.wildcardBounds = wildcardBounds
    }

    /**
     * Writes the code of this wildcard into [builder]
     */
    override fun toCode(builder: StringBuilder): StringBuilder {
        builder.append("?")
        wildcardBounds?.toCode(builder)
        return builder
    }
}