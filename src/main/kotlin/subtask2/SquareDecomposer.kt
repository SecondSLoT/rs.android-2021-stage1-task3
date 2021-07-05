package subtask2

import extentions.sqrt

class SquareDecomposer {

    fun decomposeNumber(number: Int): Array<Int>? {
        return decompose(number * number, number - 1)
    }

    private fun decompose(remainder: Int, candidate: Int): Array<Int>? {
        for (i in candidate downTo 1) {
            val candidateRemainder = remainder - i * i

            if (candidateRemainder == 0) return arrayOf(i)
            if (candidateRemainder < 0) return null

            var nextCandidate = candidateRemainder.sqrt()
            if (nextCandidate >= i) {
                nextCandidate = i - 1
            }

            val result = decompose(candidateRemainder, nextCandidate)
            if (result != null) return result + arrayOf(i)
        }

        return null
    }
}
