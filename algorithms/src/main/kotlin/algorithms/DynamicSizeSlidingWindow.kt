package algorithms

import model.DynamicSizeSlidingWindowDTO
import readFloat
import readNumberList

object DynamicSizeSlidingWindow {
    internal fun startDynamicSizeSlidingWindowProgram() {
        println(
            "Welcome to the Dynamic-Size Sliding Window! Unlike the regular Sliding Window you'll provide a " +
                    "target and the program will find the smallest window whose sum - even if it's only one number - will be " +
                    "greater than or equal to the target. Also, you must provide a number list with just positive numbers."
        )

        val numbers = readNumberList(onlyPositiveNumbers = true, listSize = 1)
        val target = readFloat("Provide a positive target: ", onlyPositiveNumbers = true)
        val dynamicSizeSlidingWindow = dynamicSlidingWindow(numbers, target)
        printResult(dynamicSizeSlidingWindow)
    }

    internal fun dynamicSlidingWindow(numbers: List<Float>, target: Float): DynamicSizeSlidingWindowDTO? {
        require(numbers.isNotEmpty()) { "Number list must not be empty" }
        require(numbers.all { it > 0f }) { "All numbers must be positive" }
        require(target > 0f) { "Target must be positive" }

        var leftIndex = 0
        var rightIndex = 0
        var sum = numbers[0]
        val isPossibleToAchieveTarget = numbers.sum() >= target
        var dynamicSizeSlidingWindow: DynamicSizeSlidingWindowDTO? = null

        if (isPossibleToAchieveTarget) {

            if (sum >= target) {
                dynamicSizeSlidingWindow = DynamicSizeSlidingWindowDTO(
                    window = 1,
                    target = target,
                    sum = sum,
                    numberList = numbers,
                    indices = 0..0
                )
                return dynamicSizeSlidingWindow
            }

            dynamicSizeSlidingWindow = null

            while (rightIndex < numbers.size - 1) {
                rightIndex++
                sum += numbers[rightIndex]

                var shouldShrinkWindow = sum - numbers[leftIndex] >= target
                while (shouldShrinkWindow) {
                    sum -= numbers[leftIndex]
                    if (leftIndex < numbers.size - 1) leftIndex++
                    shouldShrinkWindow = sum - numbers[leftIndex] >= target
                }

                val currentWindowSize = ((rightIndex - leftIndex) + 1)
                if (sum >= target
                    && (dynamicSizeSlidingWindow == null
                            || currentWindowSize < (dynamicSizeSlidingWindow.window))
                ) {
                    dynamicSizeSlidingWindow = DynamicSizeSlidingWindowDTO(
                        window = (rightIndex - leftIndex) + 1,
                        target = target,
                        sum = sum,
                        numberList = numbers,
                        indices = leftIndex..rightIndex
                    )
                }
            }

        }
        return dynamicSizeSlidingWindow
    }

    private fun printResult(dynamicSizeSlidingWindow: DynamicSizeSlidingWindowDTO?) {
        if (dynamicSizeSlidingWindow == null) {
            println("\nIt wasn't possible to find a window greater than or equal to the target.\n")
        } else {
            println(
                "It has been found the number ${dynamicSizeSlidingWindow.sum} as the greatest than or equal to the target " +
                        "${dynamicSizeSlidingWindow.target}.\nIt was used  the numberList ${dynamicSizeSlidingWindow.numberList} " +
                        "and the sum was achieved using ${dynamicSizeSlidingWindow.window} indices, from ${dynamicSizeSlidingWindow.indices.first + 1} " +
                        "to ${dynamicSizeSlidingWindow.indices.last + 1}"
            )
        }
    }
}