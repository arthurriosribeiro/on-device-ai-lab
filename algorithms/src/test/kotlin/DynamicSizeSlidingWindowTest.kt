import algorithms.DynamicSizeSlidingWindow
import model.DynamicSizeSlidingWindowDTO
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertNull
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals

class DynamicSizeSlidingWindowTest {

    @Test
    fun `Should find the best window shrinking and growing the window`() {
        val list = listOf(2f, 3f, 1f, 2f, 4f, 3f)
        val target = 7f
        val window = DynamicSizeSlidingWindow.dynamicSlidingWindow(list, target)

        assertEquals(7f, window?.sum)
        assertEquals(4..5, window?.indices)
        assertEquals(2, window?.window)
    }

    @Test
    fun `Should find the best window on first element`() {
        val list = listOf(10f, 2f, 3f)
        val target = 7f
        val window = DynamicSizeSlidingWindow.dynamicSlidingWindow(list, target)

        assertEquals(10f, window?.sum)
        assertEquals(0..0, window?.indices)
        assertEquals(1, window?.window)
    }

    @Test
    fun `Should find the best window on the last element`() {
        val list = listOf(1f, 1f, 1f, 9f)
        val target = 8f
        val window = DynamicSizeSlidingWindow.dynamicSlidingWindow(list, target)

        assertEquals(9f, window?.sum)
        assertEquals(3..3, window?.indices)
        assertEquals(1, window?.window)
    }

    @Test
    fun `Should find the first best window`() {
        val list = listOf(8f, 1f, 9f)
        val target = 7f
        val window = DynamicSizeSlidingWindow.dynamicSlidingWindow(list, target)

        assertEquals(8f, window?.sum)
        assertEquals(0..0, window?.indices)
        assertEquals(1, window?.window)
    }

    @Test
    fun `Should find the best window using the entire list`() {
        val list = listOf(1f, 2f, 3f, 4f)
        val target = 10f
        val window = DynamicSizeSlidingWindow.dynamicSlidingWindow(list, target)

        assertEquals(10f, window?.sum)
        assertEquals(0..3, window?.indices)
        assertEquals(4, window?.window)
    }

    @Test
    fun `Should find the best window in a single element list`() {
        val list = listOf(5f)
        val target = 5f
        val window = DynamicSizeSlidingWindow.dynamicSlidingWindow(list, target)

        assertEquals(5f, window?.sum)
        assertEquals(0..0, window?.indices)
        assertEquals(1, window?.window)
    }

    @Test
    fun `Should not be able to find a window`() {
        val list = listOf(1f, 2f, 3f)
        val target = 10f
        val window = DynamicSizeSlidingWindow.dynamicSlidingWindow(list, target)

        assertNull(window)
    }

    @Test
    fun `Should find the best window with decimal places`() {
        val list = listOf(0.1f, 0.2f, 0.4f)
        val target = 0.6f
        val window = DynamicSizeSlidingWindow.dynamicSlidingWindow(list, target)

        assertEquals(0.6f, window?.sum)
        assertEquals(1..2, window?.indices)
        assertEquals(2, window?.window)
    }

    @Test
    fun `Should not create a DynamicSizeSlidingWindowDTO with an empty number list`() {
        assertThrows<IllegalArgumentException> {
            DynamicSizeSlidingWindowDTO(
                window = 1,
                target = 5f,
                sum = 5f,
                numberList = emptyList(),
                indices = 0..0
            )
        }
    }

    @Test
    fun `Should not create a DynamicSizeSlidingWindowDTO with a number list containing negative numbers`() {
        assertThrows<IllegalArgumentException> {
            DynamicSizeSlidingWindowDTO(
                window = 1,
                target = 5f,
                sum = 5f,
                numberList = listOf(1f, 2f, -2f, -1f),
                indices = 0..0
            )
        }
    }

    @Test
    fun `Should not create a DynamicSizeSlidingWindowDTO with target as 0`() {
        assertThrows<IllegalArgumentException> {
            DynamicSizeSlidingWindowDTO(
                window = 3,
                target = 0f,
                sum = 5f,
                numberList = listOf(1f, 3f, 1f),
                indices = 0..3
            )
        }
    }

    @Test
    fun `Should not create a DynamicSizeSlidingWindowDTO with the sum smaller than the target`() {
        assertThrows<IllegalArgumentException> {
            DynamicSizeSlidingWindowDTO(
                window = 1,
                target = 5f,
                sum = 3f,
                numberList = listOf(1f, 3f, 2f),
                indices = 1..1
            )
        }
    }

    @Test
    fun `Should not create a DynamicSizeSlidingWindowDTO with a window unequal to the indices quantity`() {
        assertThrows<IllegalArgumentException> {
            DynamicSizeSlidingWindowDTO(
                window = 3,
                target = 5f,
                sum = 5f,
                numberList = listOf(5f),
                indices = 0..0
            )
        }
    }
}