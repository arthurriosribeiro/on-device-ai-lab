package model

data class DynamicSizeSlidingWindowDTO(
    val window: Int,
    val target: Float,
    val sum: Float,
    val numberList: List<Float>,
    val indices: IntRange,
) {
    init {
        require(numberList.isNotEmpty()) { "Number list must not be empty." }
        require(numberList.all { it > 0f }) { "All numbers must be positive." }
        require(target > 0f) { "Target must be positive." }
        require(sum >= target) { "Sum must be greater than or equal to target." }
        require(window == (indices.last - indices.first) + 1) { "Window must be equal to indices quantity." }
        require(indices.first in numberList.indices && indices.last in numberList.indices) { "Indices must be between 0 and ${numberList.size - 1}." }
    }
}