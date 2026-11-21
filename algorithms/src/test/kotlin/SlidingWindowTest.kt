import algorithms.SlidingWindow.validateWindow
import algorithms.SlidingWindow.slidingWindowSum
import model.SlidingWindowDTO
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertNull
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals

class SlidingWindowTest {

    private val numberList = listOf(0f, 1f, 2f, 3f)
    val greaterWindow = 5
    val tolerance = 0.0001f

    @Test
    fun `Should not perform sliding window`() {
        val validWindow = validateWindow(numberList, greaterWindow)
        assertNull(validWindow)
    }

    @Test
    fun `Should not allow a window greater than the number list size on the DTO construction`() {
        assertThrows<IllegalArgumentException> {
            SlidingWindowDTO(
                window = greaterWindow,
                numberList = numberList,
                sum = 0f,
                average = 0f,
                indices = 0..1,
            )
        }
    }

    @Test
    fun `Should reject a window size of zero`() {
        assertThrows<IllegalArgumentException> {
            SlidingWindowDTO(
                window = 0,
                numberList = numberList,
                sum = 0f,
                average = 0f,
                indices = 0..1,
            )
        }
    }

    @Test
    fun `Should not allow a window greater than the number list size`() {
        assertThrows<IllegalArgumentException> {
            slidingWindowSum(numberList, greaterWindow)
        }
    }

    @Test
    fun `Should find maximum average when the best window is at the end`() {
        val list = listOf(0f, 2f, 5f, 15f, 3f, 38f)
        val window = 3

        val slidingWindow = slidingWindowSum(list, window)
        assertEquals(3..5, slidingWindow.indices)
        assertEquals(56f, slidingWindow.sum)
        assertEquals(56f / 3, slidingWindow.average, tolerance)
    }

    @Test
    fun `Should reject zero-sized windows`() {
        assertThrows<IllegalArgumentException> {
            slidingWindowSum(numberList, 0)
        }
    }

    @Test
    fun `Should find maximum average when the best window is at the beginning`() {
        val list = listOf(38f, 2f, 5f, 5f, 3f, -3f)
        val window = 3

        val slidingWindow = slidingWindowSum(list, window)
        assertEquals(0..2, slidingWindow.indices)
        assertEquals(45f, slidingWindow.sum)
        assertEquals(45f / 3, slidingWindow.average, tolerance)
    }

    @Test
    fun `Should find the maximum average when the best window is at the middle`() {
        val list = listOf(0f, 2f, 38f, 5f, 3f, -3f, 2f)
        val window = 3

        val slidingWindow = slidingWindowSum(list, window)
        assertEquals(2..4, slidingWindow.indices)
        assertEquals(46f, slidingWindow.sum)
        assertEquals(46f / 3, slidingWindow.average, tolerance)
    }

    @Test
    fun `Should find the correct sum and maximum average`() {
        val list = listOf(1f, 24f, 15f, 7f, 10f)
        val window = 3
        val slidingWindow = slidingWindowSum(list, window)

        assertEquals(1..3, slidingWindow.indices)
        assertEquals(46f, slidingWindow.sum)
        assertEquals(46f / 3, slidingWindow.average, tolerance)
    }

    @Test
    fun `Should find the correct sum and average even with negative numbers`() {
        val list = listOf(-8f, -2f, -5f, -1f, -3f)
        val window = 2
        val slidingWindow = slidingWindowSum(list, window)

        assertEquals(3..4, slidingWindow.indices)
        assertEquals(-4f, slidingWindow.sum)
        assertEquals(-4f / 2, slidingWindow.average, tolerance)
    }

    @Test
    fun `Should find the correct sum and average even with a windows with the same size of the number list`() {
        val list = listOf(2f, 4f, 4f, 6f)
        val window = 4
        val slidingWindow = slidingWindowSum(list, window)

        assertEquals(0..3, slidingWindow.indices)
        assertEquals(16f, slidingWindow.sum)
        assertEquals(16f / 4, slidingWindow.average, tolerance)
    }

    @Test
    fun `Should find the correct sum and average even with a single number list`() {
        val list = listOf(2f, 4f, 6f, 8f)
        val window = 1
        val slidingWindow = slidingWindowSum(list, window)

        assertEquals(3..3, slidingWindow.indices)
        assertEquals(8f, slidingWindow.sum)
        assertEquals(8f, slidingWindow.average, tolerance)
    }

    @Test
    fun `should find maximum after a decrease in window sum`() {
        val numbers = listOf(10f, 2f, 1f, 50f)
        val window = 2
        val slidingWindow = slidingWindowSum(numbers, window)

        assertEquals(2..3, slidingWindow.indices)
        assertEquals(51f, slidingWindow.sum)
        assertEquals(51f / 2, slidingWindow.average, tolerance)
    }
}