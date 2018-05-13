package net.sourceforge.jenesis4java.j4jik

/**
 * Singleton Java code generator class.
 */
object JGenerator {
    /**
     * Creates a new ordinary compilation unit in package [jPackage] whose
     * code will be generated in a file with the given [path].
     *
     * Note that the default (empty) package is used if [jPackage] is not
     * provided.
     *
     * Take a look Java 10 JLS §7.3 for more information about ordinary
     * compilation units.
     */
    fun createOrdinaryCompilationUnit(path: String, jPackage: String = "") : JCompilationUnit {
        return JCompilationUnit(path, jPackage)
    }
}
