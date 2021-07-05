package subtask1

class Combinator {

    fun checkChooseFromArray(array: Array<Int>): Int? {

        for (i in 1..array[1]) {
            if (calcCombination(array[1], i) == array[0]) {
                return i
            }
        }
        return null
    }

    private fun calcCombination(n: Int, k: Int): Int {
        return if (n / 2 >= k) {
            (calcFactorial(n, n - k + 1) / calcFactorial(k)).toInt()
        } else {
            (calcFactorial(n, k + 1) / calcFactorial(n - k)).toInt()
        }
    }

    private fun calcFactorial(number: Int, start: Int = 1): Long {
        var num = start.toLong()
        for (i in start + 1..number) {
            num *= i
        }
        return num
    }
}
