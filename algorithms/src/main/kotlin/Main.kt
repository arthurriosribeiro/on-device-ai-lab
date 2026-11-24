import algorithms.DynamicSizeSlidingWindow
import algorithms.SlidingWindow
import algorithms.TwoPointerSum

fun main() {
    startProgram()
}

private fun startProgram() {
    val options = listOf(
        "Two pointers Sum",
        "Sliding Window",
        "Dynamic-Size Sliding Window",
        "Exit"
    )

    while (true) {
        println("==================================================")
        println("Algorithms Menu")
        println("==================================================\n")
        options.forEachIndexed { index, option ->
            println("${index + 1} - $option")
        }

        print("\nType the desired option: ")
        val optionString = readlnOrNull()?.trim()
        val option = optionString?.toIntOrNull()
        val invalidOption = (option ?: 0) > options.size || (option ?: 0) < 0
        when {
            option == null || invalidOption -> {
                println("Please, enter a valid option.\n")
            }

            option == 4 -> {
                println("\nExiting program. Farewell!")
                break
            }

            else -> {
                chooseAlgorithm(option)
            }
        }
    }
}

private fun chooseAlgorithm(option: Int) {
    when (option) {
        1 -> TwoPointerSum.startTwoPointersProgram()
        2 -> SlidingWindow.startSlidingWindowProgram()
        3 -> DynamicSizeSlidingWindow.startDynamicSizeSlidingWindowProgram()
    }
}
