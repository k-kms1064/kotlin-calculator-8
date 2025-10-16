package calculator

class StringAddCalculator {

    fun calculate(input: String?): Int {
        if (input.isNullOrBlank()) {
            return 0
        }

        val numbers = input.split(",", ":")

        return numbers.sumOf { it.toInt() }
    }
}
