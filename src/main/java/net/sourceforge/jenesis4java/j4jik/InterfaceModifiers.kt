package net.sourceforge.jenesis4java.j4jik

import java.util.*

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
     * Note: it would probably make sense to put this in an own class -
     * do it as soon as the functionality is also needed elsewhere...
     * Note that the modifiers are sorted by modified order, so that modifiers
     * are written in the customary order when [toCode] is executed.
     */
    private val modifiers: TreeSet<InterfaceModifier> =
        TreeSet(Comparator.comparingInt(InterfaceModifier::order))

    /**
     * Adds the specified [annotation] to the list of annotations of this
     * [InterfaceModifiers] instance and return the instance.
     */
    fun add(annotation: Annotation) : InterfaceModifiers{
        this.annotations.add(annotation)
        return this
    }

    /**
     * Adds the specified [modifier] to the set of interface modifiers of
     * this [InterfaceModifiers] instance and returns the instance.
     * Notes:
     * + Adding twice the same access modifier (public, private, protected) is a
     * no-operation.
     * + Trying to add two different access modifiers leads to an
     * [IllegalStateException].
     */
    fun add(modifier: InterfaceModifier): InterfaceModifiers {
        val wasModified = this.modifiers.add(modifier)
        // if a (public, private or protected) access modifier overwrote an
        // existing, different access modifier
        if (!wasModified && modifier.order == 1 && modifiers.first() != modifier) {
            throw IllegalStateException("A different access modifier is already present: ${modifiers.first()}")
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
     * Returns true if the specified [modifier] is contained in the aet
     * of interface modifiers of this [InterfaceModifiers] instance.
     */
    fun contains(modifier: InterfaceModifier): Boolean {
        return modifiers.contains(modifier)
    }

    /**
     * Returns the number of modifier keywords in this [InterfaceModifiers] instance.
     */
    fun modifierKeywordsCount(): Int {
        return modifiers.size
    }

    override fun toCode(builder: StringBuilder): StringBuilder {
        annotations.joinTo(builder, " ", transform = Codeable::toCode)
        return modifiers.joinTo(builder, " ", prefix = toCodeModifiersPrefix(), transform = InterfaceModifier::keyword)
    }

    private fun toCodeModifiersPrefix() = if (annotations.isEmpty() || modifiers.isEmpty()) "" else " "

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as InterfaceModifiers

        if (annotations != other.annotations) return false
        return sameModifiers(modifiers, other.modifiers)
    }

    /**
     * Due to the smart (?) comparision function we use in the TreeSet containing
     * the modifiers and the fact that that function is used to compare the content
     * of TreeSets, we have write our own equals method to compare modifiers the
     * way we want it: with the equals method of [InterfaceModifier]
     */
    private fun sameModifiers(modifiers: TreeSet<InterfaceModifier>, otherModifiers: TreeSet<InterfaceModifier>): Boolean {
        if (modifiers.size != otherModifiers.size) return false

        val iterator = modifiers.iterator()
        val otherIterator = otherModifiers.iterator()
        while(iterator.hasNext()) {
            if(iterator.next() != otherIterator.next()) return false
        }
        return true
    }

    override fun hashCode(): Int {
        var result = annotations.hashCode()
        result = 31 * result + modifiers.hashCode()
        return result
    }
}