
import algorithms.TwoPointerSum.twoPointersSum
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class TwoPointerSumTest {

    private val numberList = listOf(1f, 2f, 3f, 4f, 5f, 6f, 7f, 8f, 9f, 10f)

    @Test
    fun `Should find two pointers sum result`() {
        val target = 15f
        val duplicateTarget = 6f
        val negativeTarget = -1f

        val negativeNumberList = listOf(-5f, -2f, 1f, 4f)
        val duplicateNumberList = listOf(2f, 3f, 3f, 7f)

        val result = twoPointersSum(numberList, target)
        val sum = result?.let {
            numberList[it.first] + numberList[it.second]
        }

        val duplicateResult = twoPointersSum(duplicateNumberList, duplicateTarget)
        val duplicateSum = duplicateResult?.let {
            duplicateNumberList[it.first] + duplicateNumberList[it.second]
        }

        val negativeResult = twoPointersSum(negativeNumberList, negativeTarget)
        val negativeSum = negativeResult?.let {
            negativeNumberList[it.first] + negativeNumberList[it.second]
        }

        assertEquals(target, sum)
        assertEquals(duplicateTarget, duplicateSum)
        assertEquals(negativeTarget, negativeSum)
    }

    @Test
    fun `Should not find two pointers sum result`() {
        val target = 22f
        val emptyList = emptyList<Float>()

        val result = twoPointersSum(numberList, target)
        val sum = result?.let {
            numberList[it.first] + numberList[it.second]
        }

        val emptyResult = twoPointersSum(emptyList, target)
        val emptySum = emptyResult?.let {
            emptyList[it.first] + emptyList[it.second]
        }

        assertNull(sum)
        assertNull(emptySum)
    }
}