package net.sourceforge.jenesis4java.j4jik

/**
 * Singleton Java code generator class.
 */
object JGenerator {

    // TODO: thread safety! when accessing this list!
    private val unitsList = mutableListOf<JOrdinaryCompilationUnit>()

    /**
     * Resets the JGenerator.
     */
    fun clear() {
        unitsList.clear()
    }

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
    fun createOrdinaryCompilationUnit(path: String, jPackage: String = "") : JOrdinaryCompilationUnit {
        val jCompilationUnit = JOrdinaryCompilationUnit(path, jPackage)
        unitsList.add(jCompilationUnit)
        return jCompilationUnit
    }

    /**
     * Returns a read only copy pf the current list of compilation units.
     */
    fun getUnits(): List<JOrdinaryCompilationUnit> {
        return unitsList.toList()
    }
}
