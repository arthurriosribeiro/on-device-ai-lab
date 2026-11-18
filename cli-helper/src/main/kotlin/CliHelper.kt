fun readNumberList(): List<Float> {
    while (true) {
        print("Provide a number list separated by commas with at least 4 numbers: ")
        val numberListString = readlnOrNull()

        val numberList = validateNumberList(numberListString)

        if (numberList != null) {
            return numberList
        }
    }
}

fun readFloat(prompt: String): Float {
    while (true) {
        print(prompt)
        val targetString = readlnOrNull()

        val target = validateTarget(targetString)
        if (target != null) {
            return target
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