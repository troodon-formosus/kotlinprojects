package dr.clozric.lab

import dr.clozric.lab.lists.MyLinkedList
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LinkedListTest {
    @Test
    fun `isEmpty returns 'true' when the list is empty test`() {
        val myList = MyLinkedList()
        val actual = myList.isEmpty()
        assertThat(actual).isTrue()
    }

    @Test
    fun `isEmpty returns 'false' when the list contains any elements`() {
        val myList = MyLinkedList()
        myList.insert(1)
        myList.insert(2)
        myList.insert(3)
        myList.insert(4)
        myList.insert(5)
        assertThat(myList.isEmpty()).isFalse()
    }

    @Test
    fun `getHead returns first element`() {
        val myList = MyLinkedList()
        myList.insert(1)
        myList.insert(2)
        assertThat(myList.getHead()).isEqualTo(2)
    }

    @Test
    fun `getTail returns all elements that are following head element`() {
        val myList = MyLinkedList()
        myList.insert(1)
        myList.insert(2)
        myList.insert(3)
        myList.insert(4)
        myList.insert(5)
        val tail = myList.getTail()
        assertThat(tail.getHead()).isEqualTo(4)
    }

    @Test
    fun `overrideToString should return a String with all linked list elements in it`() {
        val myList = MyLinkedList()
        myList.insert(1)
        myList.insert(2)
        myList.insert(3)
        myList.insert(4)
        myList.insert(5)
        assertThat(myList.toString()).isEqualTo("[5, 4, 3, 2, 1]")
        val mySecondList = MyLinkedList()
        assertThat(mySecondList.toString()).isEqualTo("[]")
    }

    @Test
    fun `insertByIndex adds elements correctly`() {
        var myList = MyLinkedList()
        myList.insert(1)
        myList.insert(2)
        myList.insert(3)
        myList.insert(4)
        myList.insertByIndex(2, 100)
        assertThat(myList.toString()).isEqualTo("[4, 3, 100, 2, 1]")

        myList = MyLinkedList()
        myList.insertByIndex(0, 0)
        assertThat(myList.toString()).isEqualTo("[0]")

        myList = MyLinkedList()
        myList.insert(1)
        myList.insert(2)
        myList.insert(3)
        myList.insert(4)
        myList.insertByIndex(4, 2030)
        assertThat(myList.toString()).isEqualTo("[4, 3, 2, 1, 2030]")

        myList = MyLinkedList()
        myList.insert(1)
        myList.insert(2)
        myList.insert(3)
        myList.insert(4)
        val result: Boolean = myList.insertByIndex(5, 2030)
        assertThat(myList.toString()).isEqualTo("[4, 3, 2, 1]")
        assertThat(result).isFalse()
    }

    @Test
    fun `function clean should erase all elements in list`() {
        val myList = MyLinkedList()
        myList.insert(7)
        myList.insert(7)
        myList.insert(7)
        myList.insert(7)
        myList.insert(7)
        myList.insert(7)
        myList.insert(7)
        myList.clean()
        assertThat(myList.toString()).isEqualTo("[]")
    }

    @Test
    fun `deleteByIndex should delete an element correctly`() {
        val myList = MyLinkedList()
        myList.insert(1)
        myList.insert(2)
        myList.insert(3)
        myList.insert(4)
        myList.insert(5)
        myList.insert(6)
        myList.insert(7)
        assertThat(myList.deleteByIndex(3)).isEqualTo(4)
        assertThat(myList.toString()).isEqualTo("[7, 6, 5, 3, 2, 1]")
    }

    @Test
    fun `deleteByIndex returns an element`() {
        val myList = MyLinkedList()
        myList.insert(1)
        myList.insert(2)
        myList.insert(3)
        myList.insert(4)
        val deletedElem = myList.deleteByIndex(3)
        assertThat(myList.toString()).isEqualTo("[4, 3, 2]")
        assertThat(deletedElem).isEqualTo(1)
    }

    @Test
    fun `deleteByIndex deletes elements only within the linked list`() {
        val myList = MyLinkedList()
        myList.insert(1)
        myList.insert(2)
        myList.insert(3)
        myList.insert(4)
        val deletedElem = myList.deleteByIndex(4)
        assertThat(myList.toString()).isEqualTo("[4, 3, 2, 1]")
        assertThat(deletedElem).isEqualTo(null)
    }

    @Test
    fun `deleteByIndex doesn't delete anything when the linked list is empty`() {
        val myList = MyLinkedList()
        val deletedElem = myList.deleteByIndex(4)
        assertThat(myList.toString()).isEqualTo("[]")
        assertThat(deletedElem).isEqualTo(null)
    }

    @Test
    fun `deleteByIndex deletes the first element of one-element linked list correctly`() {
        val myList = MyLinkedList()
        myList.insert(1)
        val deletedElem = myList.deleteByIndex(0)
        assertThat(myList.toString()).isEqualTo("[]")
        assertThat(deletedElem).isEqualTo(1)
    }
}
