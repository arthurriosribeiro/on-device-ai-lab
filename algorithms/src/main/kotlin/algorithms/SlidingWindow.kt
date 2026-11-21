package algorithms

import model.SlidingWindowDTO
import readNumberList
import readInt

object SlidingWindow {
    internal fun startSlidingWindowProgram() {
        val numberList = readNumberList()

        val window = readInt("Provide the desired number quantity: ")

        validateWindow(numberList, window)
    }

    internal fun validateWindow(numberList: List<Float>, window: Int) : SlidingWindowDTO? {
        if (numberList.size < window) {
            println("The number quantity is bigger than the number quantity in the list.")
            return null
        } else {
            val slidingWindow = slidingWindowSum(numberList, window)

            printResult(slidingWindow)
            return slidingWindow
        }
    }

    internal fun slidingWindowSum(numbers: List<Float>, window: Int): SlidingWindowDTO {

        require(window in 1..numbers.size) {
            "Window must be between 1 and ${numbers.size}"
        }

        var firstIndex = 0
        var lastIndex = window - 1
        var sum: Float
        var maxSum: Float
        var average: Float
        var slidingWindow: SlidingWindowDTO
        val sumList = numbers.subList(firstIndex, window)
        sum = sumList.sum()
        maxSum = sum
        slidingWindow = SlidingWindowDTO(
            window = window,
            sum = maxSum,
            average = maxSum / window,
            numberList = numbers,
            indexes = 0..lastIndex
        )

        while (lastIndex < numbers.size - 1) {
            val outgoingNumber = numbers[firstIndex]
            firstIndex++
            lastIndex = firstIndex + (window - 1)
            val currentSum = sum - outgoingNumber + numbers[lastIndex]
            sum = currentSum

            if (maxSum < currentSum) {
                maxSum = currentSum
                average = currentSum / window
                slidingWindow = SlidingWindowDTO(
                    window = window,
                    sum = maxSum,
                    average = average,
                    numberList = numbers,
                    indexes = firstIndex..lastIndex
                )
            }
        }

        return slidingWindow
    }

    private fun printResult(slidingWindowDTO: SlidingWindowDTO?) {
        if (slidingWindowDTO == null) {
            println("No sliding-window found")
        } else {
            println("Using the list ${slidingWindowDTO.numberList} and getting ${slidingWindowDTO.window} numbers from this list" +
                    "on index ${slidingWindowDTO.indexes}, " +
                    "we get a sum result ${slidingWindowDTO.sum} with ${slidingWindowDTO.average} as average.")
        }
    }
}