package model

data class SlidingWindowDTO(
    val window: Int,
    val sum: Float,
    val average: Float,
    val numberList: List<Float>,
    val indices: IntRange
) {
    init {
        require(window in 1..numberList.size) {
            "Window must be between 1 and ${numberList.size}"
        }

        require((indices.last - indices.first) + 1 == window
                && indices.first in numberList.indices && indices.last in numberList.indices) {
            "The indices must match the window size and stay within the list bounds"
        }
    }
}
