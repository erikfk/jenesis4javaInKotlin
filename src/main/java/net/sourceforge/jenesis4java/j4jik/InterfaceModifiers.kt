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
    * Set containing the interface modifiers other than annotations.
     */
    private val modifierKeywords: MutableSet<InterfaceModifierKeyword> = HashSet()

    /**
     * Adds the specified [annotation] to the list of annotations of this
     * [InterfaceModifiers] instance.
     */
    fun add(annotation: Annotation) {
        this.annotations.add(annotation)
    }

    /**
     * Adds the specified [modifier] to the set of interface modifiers of
     * this [InterfaceModifiers] instance.
     */
    fun add(modifier: InterfaceModifierKeyword) {
        this.modifierKeywords.add(modifier)
    }

    /**
     * Returns true if the specified [annotation] is contained in the list of
     * annotations of this [InterfaceModifiers] instance.
     */
    fun contains(annotation: Annotation): Boolean {
        return this.annotations.contains(annotation)
    }

    /**
     * Returns true if the specified [modifierKeyword] is contained in the aet
     * of interface modifiers of this [InterfaceModifiers] instance.
     */
    fun contains(modifierKeyword: InterfaceModifierKeyword): Boolean {
        return modifierKeywords.contains(modifierKeyword)
    }

    /**
     * Returns the number of Annotations in this  [InterfaceModifiers] instance.
     */
    fun annotationsCount(): Int {
        return annotations.size
    }

    /**
     * Returns the number of modifier keywords in this  [InterfaceModifiers] instance.
     */
    fun modifierKeywordsCount(): Int {
        return modifierKeywords.size
    }
}