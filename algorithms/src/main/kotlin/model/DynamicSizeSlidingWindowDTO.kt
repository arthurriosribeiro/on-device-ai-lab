package model

class DynamicSizeSlidingWindowDTO(
    val window: Int,
    val target: Float,
    val sum: Float,
    val numberList: List<Float>,
    val indices: IntRange,
)