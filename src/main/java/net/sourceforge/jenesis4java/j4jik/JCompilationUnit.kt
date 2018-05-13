package net.sourceforge.jenesis4java.j4jik

/**
 * Models an ordinary compilation unit in package [jPackage] whose
 * code will be generated in a file with the given [path].
 *
 * Take a look Java 10 JLS §7.3 for more information about ordinary
 * compilation units.
 *
 * Note that the class is <i>not</i> called JOrdinaryCompilationUnit for the sake
 * of conciseness.
 *
 * @param[path] path of file to which the code for the new JCompilationUnit will
 *              be generated.
 * @param[jPackage] Package the new JCompilationUnit belongs to
 */
class JCompilationUnit(val path: String, val jPackage: String = "") {
}