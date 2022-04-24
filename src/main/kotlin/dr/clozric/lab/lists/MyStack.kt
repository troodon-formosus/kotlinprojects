package dr.clozric.lab.lists

class Stack (arrayLength: Int = 12) {
    private var top = -1
    private val myArray = Array<Int>(arrayLength, this::initialise)
    private fun initialise(i: Int): Int {
        return 0
    }

    fun push(elem: Int) {
        myArray[top + 1] = elem
        top += 1
    }

    fun pop(): Int {
        top -= 1
        return myArray[top + 1]
    }
}
