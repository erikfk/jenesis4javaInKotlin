package net.sourceforge.jenesis4java.j4jik

/**
 * Models an ordinary compilation unit in package [jPackage] whose
 * code will be generated in a file with the given [path].
 *
 * Take a look Java 10 JLS §7.3 for more information about ordinary
 * compilation units.
 *
 * @param[path] path of file to which the code for the new JOrdinaryCompilationUnit will
 *              be generated.
 * @param[jPackage] Package the new JOrdinaryCompilationUnit belongs to
 */
class JOrdinaryCompilationUnit(val path: String, val jPackage: String = "") {

    /**
     * Human readable descrition of JOrdinaryCompilationUnit instance
     */
    override fun toString(): String {
        return "JOrdinaryCompilationUnit(path='$path', jPackage='$jPackage')"
    }
}