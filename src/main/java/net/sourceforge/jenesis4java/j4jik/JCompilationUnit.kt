package net.sourceforge.jenesis4java.j4jik

/**
 * Models an ordinary compilation unit. See Java 10 JLS §7.3.
 *
 * Note that the class is <i>not</i> called JOrdinaryCompilationUnit for the sake
 * of conciseness.
 */
class JCompilationUnit(val path: String, val jPackage: String = "") {
}