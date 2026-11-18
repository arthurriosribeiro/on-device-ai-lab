package algorithms

import model.SlidingWindowDTO
import readNumberList
import readInt

object SlidingWindow {
    internal fun startSlidingWindowProgram() {
        val numberList = readNumberList()

        val target = readInt("Provide the desired number quantity: ")

        if (numberList.size < target) {
            println("The number quantity is bigger than the number quantity in the list.")
        } else {
            val slidingWindow = slidingWindowSum(numberList, target)

            printResult(slidingWindow)
        }
    }

    internal fun slidingWindowSum(numbers: List<Float>, target: Int): SlidingWindowDTO? {
        var firstIndex = -1
        var lastIndex = 0
        var sum: Float
        var average = 0f
        var slidingWindow: SlidingWindowDTO? = null

        while (lastIndex < numbers.size - 1) {
            firstIndex++
            lastIndex = firstIndex + target
            val sumList = numbers.subList(firstIndex, lastIndex)
            sum = sumList.sum()
            val currentAverage = sumList.average().toFloat()
            println("Current average: $currentAverage")

            if (average < currentAverage) {
                average = currentAverage
                slidingWindow = SlidingWindowDTO(
                    target = target,
                    sum = sum,
                    average = average,
                    numberList = numbers,
                    indexes = listOf(firstIndex..lastIndex)
                )
            } else break
        }

        return slidingWindow
    }

    private fun printResult(slidingWindowDTO: SlidingWindowDTO?) {
        if (slidingWindowDTO == null) {
            println("No sliding-window found")
        } else {
            println("Using the list ${slidingWindowDTO.numberList} and getting ${slidingWindowDTO.target} numbers from this list" +
                    "on index ${slidingWindowDTO.indexes}, " +
                    "we get a sum result ${slidingWindowDTO.sum} with ${slidingWindowDTO.average} as average.")
        }
    }
}