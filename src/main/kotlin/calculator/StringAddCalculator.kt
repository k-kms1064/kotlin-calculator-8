package calculator

class StringAddCalculator {

    fun calculate(input: String?): Int {
        if (input.isNullOrBlank()) return 0

        var delimiters = listOf(",", ":")
        var numbersPart = input

        val customPattern = Regex("//(.)\n(.*)")
        val matchResult = customPattern.matchEntire(input)
        if (matchResult != null) {
            val (customDelimiter, numbers) = matchResult.destructured
            delimiters = delimiters + customDelimiter
            numbersPart = numbers
        }

        val regex = delimiters.joinToString("|") { Regex.escape(it) }.toRegex()
        val numbers = numbersPart.split(regex).filter { it.isNotBlank() }

        return numbers.sumOf { str ->
            val num = str.toIntOrNull()
                ?: throw IllegalArgumentException("숫자가 아닙니다: '$str'")
            require(num >= 0) { "음수는 허용되지 않습니다: $num" }
            num
        }
    }
}
