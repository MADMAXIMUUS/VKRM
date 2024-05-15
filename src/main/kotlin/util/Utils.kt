package util

fun <T : Comparable<T>> ClosedRange<T>.intersect(other: ClosedRange<T>): ClosedRange<T>? {
    if (endInclusive < other.start || other.endInclusive < start) {
        return null
    }

    val intersectionStart = maxOf(start, other.start)
    val intersectionEnd = minOf(endInclusive, other.endInclusive)

    return intersectionStart..intersectionEnd
}