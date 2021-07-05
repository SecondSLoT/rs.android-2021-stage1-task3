package subtask3

class TelephoneFinder {

    private val neighbors = arrayListOf<String>()

    fun findAllNumbersFromGivenNumber(number: String): Array<String>? {

        if (number[0] == '-') return null

        val keyboard = arrayOf('1', '2', '3', '4', '5', '6', '7', '8', '9', null, '0', null)

        for (i in number.indices) {
            val position = keyboard.indexOf(number[i])
            // Если есть число на ряд выше
            keyboard.getOrNull(position - 3)?.let { addNeighbor(number, i, it) }

            // Если есть число на ряд ниже
            keyboard.getOrNull(position + 3)?.let { addNeighbor(number, i, it) }

            // Если есть число слева (для нахождения в одномерном массиве, проверяем, чтобы
            // число слева было в одном ряду с нашим числом
            if (position / 3 == (position - 1) / 3) {
                keyboard.getOrNull(position - 1)?.let { addNeighbor(number, i, it) }
            }

            // Если есть число справа (для нахождения в одномерном массиве пользуемся
            // тем же методом, как со случаем числа слева)
            if (position / 3 == (position + 1) / 3) {
                keyboard.getOrNull(position + 1)?.let { addNeighbor(number, i, it) }
            }
        }

        return neighbors.toTypedArray()
    }

    private fun addNeighbor(number: String, position: Int, char: Char) {
        val stringBuilder = StringBuilder(number)
        stringBuilder.setCharAt(position, char)
        neighbors.add(stringBuilder.toString())
    }
}
