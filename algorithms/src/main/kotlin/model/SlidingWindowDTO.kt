package model

data class SlidingWindowDTO(
    val window: Int,
    val sum: Float,
    val average: Float,
    val numberList: List<Float>,
    val indexes: IntRange
) {
    init {
        require(window in 1..numberList.size) {
            "Window must be between 1 and ${numberList.size}"
        }
    }
}
