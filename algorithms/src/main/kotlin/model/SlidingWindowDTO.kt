package model

data class SlidingWindowDTO(
    val target: Int,
    val sum: Float,
    val average: Float,
    val numberList: List<Float>,
    val indexes: List<IntRange>
)
