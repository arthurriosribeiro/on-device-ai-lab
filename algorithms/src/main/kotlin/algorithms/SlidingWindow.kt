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
        var firstIndex = 0
        var lastIndex = target - 1
        var sum: Float
        var maxSum: Float
        var average: Float
        var slidingWindow: SlidingWindowDTO? = null
        val sumList = numbers.subList(firstIndex, target)
        sum = sumList.sum()
        maxSum = sum
        slidingWindow = SlidingWindowDTO(
            target = target,
            sum = maxSum,
            average = maxSum / target,
            numberList = numbers,
            indexes = listOf(0..lastIndex)
        )

        while (lastIndex < numbers.size - 1) {
            val outgoingNumber = numbers[firstIndex]
            firstIndex++
            lastIndex = firstIndex + (target - 1)
            val currentSum = sum - outgoingNumber + numbers[lastIndex]
            sum = currentSum

            if (maxSum < currentSum) {
                maxSum = currentSum
                average = currentSum / target
                slidingWindow = SlidingWindowDTO(
                    target = target,
                    sum = maxSum,
                    average = average,
                    numberList = numbers,
                    indexes = listOf(firstIndex..lastIndex)
                )
            }
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