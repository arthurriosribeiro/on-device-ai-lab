fun getIndexLabel(index: Int): String {
    return when (index) {
        1 -> "first"
        2 -> "second"
        3 -> "third"
        else -> "${index}th"
    }
}

fun validateNumberList(input: String?, listSize: Int): List<Float>? {
    val items = input?.split(",")
    val numberList = mutableListOf<Float>()

    if (items == null) {
        println("Please, provide a list with valid numbers.")
    } else if (items.any { it.toFloatOrNull() == null }) {
        println("All elements must be a number")
    } else if (items.size < listSize) {
        println("Please enter at least $listSize numbers")
    } else {
        items.forEach { numberList.add(it.trim().toFloat()) }
        return numberList
    }

    return null
}

fun validateTarget(input: String?): Float? {
    val targetNumber = input?.toFloatOrNull()

    if (targetNumber == null) {
        println("Please enter a valid number.")
        return null
    } else {
        return targetNumber
    }
}