package extentions

import kotlin.math.log
import kotlin.math.sqrt

fun Int.pow(degree: Int): Int {
    if (degree == 0) return 1
    if (degree == 1) return this

    var result = this

    for (i in 2..degree) {
        result *= this
    }

    return result
}

fun Int.log(): Int {
    return log(this.toDouble(), 2.0).toInt()
}

fun Int.sqrt(): Int {
    return sqrt(this.toDouble()).toInt()
}
