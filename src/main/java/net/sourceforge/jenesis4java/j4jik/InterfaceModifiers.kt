package net.sourceforge.jenesis4java.j4jik

/**
 * Models a group of interface modifiers (for an interface etc.).
 *
 * See JLS 10 §9.1.1
 */
class InterfaceModifiers {
    /**
    * List of annotations of the [InterfaceModifiers] instance.
     */
    private val annotations: MutableList<Annotation> = ArrayList()

    /**
    * Set containing the interface modifiers other than the annotations.
     */
    val modifierKeywords: MutableSet<InterfaceModifierKeyword> = HashSet()

    /**
     * Adds the specified [annotation] to the list of annotations of annotations of this
     * [InterfaceModifiers] instance.
     */
    fun add(annotation: Annotation) {
        this.annotations.add(annotation)
    }

    /**
     * Returns true if the specified [annotation] is contained in the list of annotations of this
     * [InterfaceModifiers] instance.
     */
    fun contains(annotation: Annotation): Boolean {
        return this.annotations.contains(annotation)
    }

    /**
     * Returns the number of Annotations in this  [InterfaceModifiers] instance.
     */
    fun annotationsCount(): Int {
        return annotations.size
    }
}