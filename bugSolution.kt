```kotlin
fun main() {
    // Using iterators for consistent behavior across collection types
    fun <T> MutableCollection<T>.removeIfConsistent(predicate: (T) -> Boolean) {
        val iterator = iterator()
        while (iterator.hasNext()) {
            if (predicate(iterator.next())) {
                iterator.remove()
            }
        }
    }

    val list = mutableListOf(1, 2, 3, 4, 5)
    list.removeIfConsistent { it > 2 }
    println(list) // Output: [1, 2]

    val set = mutableSetOf(1, 2, 3, 4, 5)
    set.removeIfConsistent { it > 2 }
    println(set) // Output: [1, 2]

    val map = mutableMapOf(1 to "a", 2 to "b", 3 to "c")
    map.removeIfConsistent { it.key > 2 }
    println(map) // Output: {1=a, 2=b}
}
```