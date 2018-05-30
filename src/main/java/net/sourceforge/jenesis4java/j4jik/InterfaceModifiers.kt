package net.sourceforge.jenesis4java.j4jik

import java.util.*
import java.util.stream.Collectors.*

/**
 * Models a group of interface modifiers (for an interface etc.).
 *
 * See JLS 10 §9.1.1
 */
class InterfaceModifiers : Codeable {
    /**
     * List of annotations of the [InterfaceModifiers] instance.
     */
    private val annotations: MutableList<Annotation> = ArrayList()

    /**
     * Set containing the interface modifiers other than annotations.
     */
    private val modifierKeywords: MutableSet<InterfaceModifierKeyword> =
        TreeSet(Comparator.comparingInt(InterfaceModifierKeyword::order))

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
     * Notes:
     * Adding twice the same access modifier (public, private, protected) is a
     * no-operation. Trying to add two different access modifiers leads to an
     * [IllegalStateException].
     */
    fun add(modifier: InterfaceModifierKeyword): InterfaceModifiers {
        val wasModified = this.modifierKeywords.add(modifier)
        if (!wasModified && modifier.order == 1 && modifierKeywords.first() != modifier) {
            throw IllegalStateException("A different access modifier is already present: ${modifierKeywords.first()}")
        }
        return this
    }

    /**
     * Returns the number of Annotations in this  [InterfaceModifiers] instance.
     */
    fun annotationsCount(): Int {
        return annotations.size
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
     * Returns the number of modifier keywords in this  [InterfaceModifiers] instance.
     */
    fun modifierKeywordsCount(): Int {
        return modifierKeywords.size
    }

    override fun toCode(builder: StringBuilder): StringBuilder {
        return builder.append(modifierKeywords.stream().map(InterfaceModifierKeyword::value).collect(joining(" ")))
    }
}