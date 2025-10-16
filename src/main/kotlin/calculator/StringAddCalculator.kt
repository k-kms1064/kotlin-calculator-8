package calculator

class StringAddCalculator {

    fun calculate(input: String?): Int {
        if (input.isNullOrBlank()) {
            return 0
        }

        var delimiters = listOf(",", ":")

        var numbersPart = input

        if (input.startsWith("//")) {
            val parts = input.split("\n", limit = 2)
            if (parts.size < 2) {
                throw IllegalArgumentException("커스텀 구분자 형식이 잘못되었습니다.")
            }

            val customDelimiter = parts[0].substring(2)
            delimiters = delimiters + customDelimiter
            numbersPart = parts[1]
        }

        val regex = delimiters.joinToString("|") { Regex.escape(it) }.toRegex()
        val numbers = numbersPart.split(regex)

        return numbers.sumOf { it.toInt() }
    }
}
