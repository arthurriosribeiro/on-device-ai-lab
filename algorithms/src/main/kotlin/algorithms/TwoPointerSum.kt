package algorithms

import getIndexLabel
import readNumberList
import readFloat

object TwoPointerSum {
    internal fun startTwoPointersProgram() {
        val numberList = readNumberList()

        val targetNumber = readFloat("Provide the desired sum target: ")


        val sortedList = numberList.sorted()
        val result = twoPointersSum(sortedList, targetNumber)

        printResult(result, sortedList, targetNumber)
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
                        "number and the ${getIndexLabel(result.second + 1)} number.\n"
            )
            println("${numberList[result.first]} + ${numberList[result.second]} = $target\n")
        }
    }
}