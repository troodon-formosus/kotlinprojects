package dr.clozric.lab.lists

class MyLinkedList {
    private var _head: Node? = null

    fun insert(elem: Int) {
        val node = Node(elem, _head)
        _head = node
    }

    fun isEmpty(): Boolean {
        return _head == null
    }

    fun getHead(): Int {
        if (_head == null) {
            throw IllegalStateException()
        }
        return _head!!.data
    }

    fun getTail(): MyLinkedList {
        if (_head == null) {
            throw IllegalStateException()
        }
        val newList = MyLinkedList()
        newList._head = _head!!.next
        return newList
    }

    fun insertByIndex(i: Int, elem: Int): Boolean {
        if (i == 0 && _head == null) {
            _head = Node(elem, null)
            return true
        }

        var pointer: Node? = _head
        var index: Int = 0
        while (index + 1 < i && pointer != null) {
            index += 1
            pointer = pointer.next
        }

        if (index + 1 <= i && pointer == null) {
            return false
        }

        val node: Node = Node(elem, pointer!!.next)
        pointer.next = node
        return true
    }

    override fun toString(): String {
        val elementsOfLinkedList: StringBuilder = StringBuilder()
        elementsOfLinkedList.append("[")

        var pointer: Node? = _head
        while (pointer != null && pointer.next != null) {
            elementsOfLinkedList.append("${pointer.data}, ")
            pointer = pointer.next
        }
        if (pointer != null && pointer.next == null) {
            elementsOfLinkedList.append(pointer.data)
        }

        elementsOfLinkedList.append("]")
        return elementsOfLinkedList.toString()
    }

    fun deleteByIndex(i: Int): Int? {
        if (_head != null && _head!!.next == null) {
            val elem = _head!!.data
            _head = null
            return elem
        }

        var iteration: Int = 0
        var pointer: Node? = _head
        while (iteration + 1 < i && pointer != null) {
            iteration += 1
            pointer = pointer.next
        }

        if (pointer == null || pointer.next == null) {
            return null
        }

        val elem: Int = pointer!!.next!!.data
        pointer.next = pointer.next!!.next
        return elem
    }

    fun clean() {
        _head = null
    }

    private class Node(val data: Int,
                       var next: Node?)
}
