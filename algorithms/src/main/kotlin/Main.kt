fun main() {
    startProgram()
}

private fun startProgram() {
    while (true) {
        val numberList = readValidNumberList()
        println()

        val targetNumber = readValidTarget()

        twoPointerSum(numberList, targetNumber)
    }
}

private fun readValidNumberList(): List<Float> {
    while (true) {
        print("Provide a number list separated by commas with at least 4 numbers: ")
        val numberListString = readlnOrNull()
        val items = numberListString?.split(",")
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
    }
}

private fun readValidTarget(): Float {
    while (true) {
        print("Now provide the desired sum target: ")
        val targetString = readlnOrNull()
        val targetNumber = targetString?.toFloatOrNull()

        if (targetNumber == null) {
            println("Please enter a valid number.")
        } else {
            return targetNumber
        }
    }
}

private fun twoPointerSum(numberList: List<Float>, target: Float) : Pair<Int, Int>? {
    var leftPointIndex = 0
    var rightPointIndex = numberList.size - 1
    var points: Pair<Int, Int>? = Pair(leftPointIndex, rightPointIndex)
    val sortedList = numberList.sorted()
    while (leftPointIndex < rightPointIndex) {
        val sum = sortedList[leftPointIndex] + sortedList[rightPointIndex]

        if (sum == target) {
            println("To achieve your target, we sum the ${leftPointIndex + 1}th number and the ${rightPointIndex + 1}th number.")
            println("${sortedList[leftPointIndex]} + ${sortedList[rightPointIndex]} = $target\n")
            break
        } else if (sum < target) {
            leftPointIndex++
            points = Pair(leftPointIndex, rightPointIndex)
        } else {
            rightPointIndex--
            points = Pair(leftPointIndex, rightPointIndex)
        }
    }

    if (leftPointIndex == rightPointIndex) {
        println("It is not possible to achieve your target using the provided number list.\n")
        points = null
    }

    print("Pair: $points\n")
    return points
}