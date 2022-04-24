package dr.clozric.lab

import dr.clozric.lab.literaltype.divideText
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class UnitTests {
    @Test
    fun `divide text successfully test`() {
        val inputData: String = "aaaa, aaaaaa, aaaaaaaa"
        val expected: String = "aaaa\n,\n aaa\naaa,\n aaa\naaaa\na"
        val actual: String = divideText(inputData, 4)
        assertEquals(expected, actual)
    }

    @Test
    fun `keep text without changes if character number is under limit test`() {
        val inputData: String = "aaa"
        val expected: String = "aaa"
        val actual: String = divideText(inputData, 4)
        assertEquals(expected, actual)
    }
}
