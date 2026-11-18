import algorithms.SlidingWindow
import algorithms.TwoPointerSum

fun main() {
    startProgram()
}

private fun startProgram() {
    val options = listOf(
        "Two pointers Sum",
        "Sliding Window",
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
        when (val option = optionString?.toIntOrNull()) {
            null -> {
                println("Please, enter a valid option.")
            }
            3 -> {
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
    }
}
