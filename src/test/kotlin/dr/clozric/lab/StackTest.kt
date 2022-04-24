package dr.clozric.lab

import dr.clozric.lab.lists.Stack
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class StackTest {
    @Test
    fun `stack should return relevant value on pop operation test`() {
        val stack = Stack()
        stack.push(4)
        stack.push(2)
        var poppedItem = stack.pop()
        assertThat(poppedItem).isEqualTo(2)
        poppedItem = stack.pop()
        assertThat(poppedItem).isEqualTo(4)
    }

    @Test
    fun `attempt to pop element on empty stack throws exception test`() {
        val stack = Stack()
        stack.pop()
    }
}
