package homework

/** find - გადაეწოდება პრედიკატი,
 * თუ სიაში რომელიმე ელემენტი დააკმაყოფილებს ამ პრედიკატს
 * დააბრუნეთ ის ელემენტი თუ არადა null.
 */
fun <T> List<T>.find(predicate: (T) -> Boolean): T? {
    for (item in this) {
        if (predicate(item)) return item
    }
    return null
}

fun <T> List<T>.find2(block: Int): T? {
    return if (block in 0..lastIndex) get(block) else null
}

/** first - გადაეწოდება პრედიკატი,
 * თუ სიაში რომელიმე ელემენტი დააკმაყოფილებს ამ პრედიკატს
 * დააბრუნეთ ელემენტთი თუ არადა ისროლეთ NoSuchElementException ექსეფშენი.
 */
fun <T> List<T>.first(predicate: (T) -> Boolean): T? {
    for (item in this) {
        if (predicate(item)) return item
    }
    throw NoSuchElementException("The element was not found!")
}

fun <T> List<T>.first2(block: Int): T {
    return if (block in 0..lastIndex) get(block) else throw NoSuchElementException()
}

/** forEach - გადაეწოდება ლამბდა პარამეტრი,
 * რომელიც სიაში ყველა ელემენტესთვის იძახებს ლამბდას. უკან არ აბრუნებს არაფერს.
 */
fun <T> List<T>.forEachTest(lambda: (T) -> Unit) {
    for (item in this) {
        lambda(item)
    }
}

/** all - გადაეწოდება პრედიკატი,
 * აბრუნებს true-ს თუ ყველა ელემენტი სიაში აკმაყოფილებს ამ პრედიკატს,
 * წინააღმდეგ შემთხვევაში აბრუნებს false-ს.
 */
fun <T> List<T>.all(predicate: (T) -> Boolean): Boolean {
    for (item in this) {
        if (!predicate(item)) return false
    }
    return true
}

fun main() {

    val numbers = listOf(1, 2, 3, 4, 5)
    val strings = listOf("One", "Two", "Three", "Four", "Five")

    println(numbers.find { it == 4 })
    println(strings.find { it.startsWith("Th") })
    println(strings.first { it == "Five" })
    println(numbers.all { it < 5 })

    strings.forEachTest { println(it.toUpperCase()) }

    numbers.forEach { list: Int -> println(list) }
}
