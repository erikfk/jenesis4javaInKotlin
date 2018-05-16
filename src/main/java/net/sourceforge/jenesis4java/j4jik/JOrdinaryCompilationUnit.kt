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
 * @param[jPackage] Package the new JOrdinaryCompilationUnit belongs to. Defaults to
 *              empty (the default, unnamed package)
 * @constructor Creates an ordinary compilation unit without imports or
 */
class JOrdinaryCompilationUnit(val path: String, val jPackage: String = "") {
    private val imports = ArrayList<Import>()

    /**
     * Adds the given [import] to the list of imports of this JOrdinaryCompilationUnit
     */
    fun addImport(import: Import) {
        imports.add(import)
    }

    /**
     * Returns a copy of the list of imports.
     */
    fun getImports() : List<Import> {
        return imports.toList()
    }

    /**
     * Simple human readable description of JOrdinaryCompilationUnit instance
     */
    override fun toString(): String {
        return "JOrdinaryCompilationUnit(path='$path', jPackage='$jPackage', imports=$imports)"
    }
}