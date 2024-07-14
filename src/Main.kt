fun isValidBracket(str: String): Boolean {
    val stack = mutableListOf<Char>()// лист для использования в формате стэка скобок
    val pairs = mapOf(')' to '(', ']' to '[', '}' to '{')

    for (bracket in str) {
        when (bracket) {
            '(', '{', '[' -> stack.add(bracket) // добавление скобки в стэк
            ')', '}', ']' -> {
                return !(stack.isEmpty() || pairs[bracket] != stack.removeLast())
            } // проверка стэка при получении закрывающей скобки
        }
    }

    return true
}

fun main() {
    val checkBrackets = listOf("()", "()[]{}", "(]", "([)]", "{[]}", "{[()]}") // скобки для проверки
    for (pair in checkBrackets) {
        println("$pair: ${isValidBracket(pair)}")
    } // вывод результата
}