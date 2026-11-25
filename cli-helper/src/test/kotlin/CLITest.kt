import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class CLITest {

    @Test
    fun `Should read a list containing just numbers`() {
        val numbersInput = "1, 2, 3, 4, 5, 6, 7, 8, 9, 10"
        val fewerThanFour = "1, 2, 3"
        val empty = ""
        val notNumbersInput = "1, 5, c, l"

        assertEquals(listOf(1f, 2f, 3f, 4f, 5f, 6f, 7f, 8f, 9f, 10f), validateNumberList(numbersInput))
        assertNull(validateNumberList(notNumbersInput))
        assertNull(validateNumberList(fewerThanFour))
        assertNull(validateNumberList(empty))
    }

    @Test
    fun `Should read a valid target`() {
        val numberInput = "10"
        val notNumberInput = "c"

        assertEquals(10f, validateTarget(numberInput))
        assertNull(validateTarget(notNumberInput))
    }
}