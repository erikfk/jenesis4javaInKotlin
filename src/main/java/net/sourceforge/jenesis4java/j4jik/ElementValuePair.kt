package net.sourceforge.jenesis4java.j4jik

/**
 * Models an element value pair of a [NormalAnnotation].
 *
 * See JLS 10 §9.7.1
 *
 * @param[identifier] identifier part of the element value pair
 * @param[elementValue] element value part of the element value pair
 */
class ElementValuePair(val identifier: String, val elementValue: ElementValue) {
}