fun readNumberList(allowNegativeNumbers: Boolean = true, listSize: Int = 4): List<Float> {
    while (true) {
        print("Provide a number list separated by commas with at least $listSize number(s): ")
        val numberListString = readlnOrNull()

        val numberList = validateNumberList(numberListString, listSize)

        if (numberList != null) {
            if (!allowNegativeNumbers && numberList.any { it < 0 }) {
                println("\nPlease, provide a number list containing just positive numbers\n")
            } else {
                return numberList
            }
        }
    }
}

fun readFloat(prompt: String, allowNegativeNumbers: Boolean = true): Float {
    while (true) {
        print(prompt)
        val targetString = readlnOrNull()

        val target = validateTarget(targetString)

        if (target != null) {
            if (!allowNegativeNumbers && target < 0) {
                println("Please, provide a positive target")
            } else {
                return target
            }
        }
    }
}

fun readInt(prompt: String): Int {
    while (true) {
        print(prompt)
        val targetString = readlnOrNull()

        val target = validateTarget(targetString)?.toInt()
        if (target != null) {
            return target
        }
    }
}