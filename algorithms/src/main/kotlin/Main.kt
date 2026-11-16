fun main() {
    startProgram()
}

private fun startProgram() {
    while (true) {
        val numberList = readNumberList()

        val targetNumber = readTarget()


        val sortedList = numberList.sorted()
        val result = twoPointersSum(sortedList, targetNumber)

        printResult(result, sortedList, targetNumber)
    }
}

private fun readNumberList(): List<Float> {
    while (true) {
        print("Provide a number list separated by commas with at least 4 numbers: ")
        val numberListString = readlnOrNull()

        val numberList = validateNumberList(numberListString)

        if (numberList != null) {
            return numberList
        }
    }
}

private fun readTarget(): Float {
    while (true) {
        print("Now provide the desired sum target: ")
        val targetString = readlnOrNull()

        val target = validateTarget(targetString)
        if (target != null) {
            return target
        }
    }
}

internal fun validateNumberList(input: String?): List<Float>? {
    val items = input?.split(",")
    val numberList = mutableListOf<Float>()

    if (items == null) {
        println("Please, provide a list with valid numbers.")
    } else if (items.any { it.toFloatOrNull() == null }) {
        println("All elements must be a number")
    } else if (items.size < 4) {
        println("Please enter at least 4 numbers")
    } else {
        items.forEach { numberList.add(it.trim().toFloat()) }
        return numberList
    }

    return null
}

internal fun validateTarget(input: String?): Float? {
    val targetNumber = input?.toFloatOrNull()

    if (targetNumber == null) {
        println("Please enter a valid number.")
        return null
    } else {
        return targetNumber
    }
}

internal fun twoPointersSum(numberList: List<Float>, target: Float): Pair<Int, Int>? {
    var leftPointIndex = 0
    var rightPointIndex = numberList.size - 1
    while (leftPointIndex < rightPointIndex) {
        val sum = numberList[leftPointIndex] + numberList[rightPointIndex]

        if (sum == target) {
            return Pair(leftPointIndex, rightPointIndex)
        } else if (sum < target) {
            leftPointIndex++
        } else {
            rightPointIndex--
        }
    }

    return null
}

private fun printResult(result: Pair<Int, Int>?, numberList: List<Float>, target: Float) {
    if (result == null) {
        println("It is not possible to achieve your target using the provided number list.\n")
    } else {

        println(
            "To achieve your target, we sum the ${getIndexLabel(result.first + 1)} " +
                    "number and the ${getIndexLabel(result.second + 1)} number."
        )
        println("${numberList[result.first]} + ${numberList[result.second]} = $target\n")
    }
}

private fun getIndexLabel(index: Int): String {
    return when (index) {
        1 -> "first"
        2 -> "second"
        3 -> "third"
        else -> "${index}th"
    }
}