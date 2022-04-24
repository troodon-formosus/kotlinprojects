package dr.clozric.lab.literaltype

import java.io.FileReader

fun divideText(text: String, stringLengthLimit: Int, breakChar: Char = ','): String {
    val textOutput: StringBuilder = StringBuilder()
    var symbolsAfterNewLine: Int = 1
    for (i in text.indices) {
        textOutput.append(text[i])
        val symbol: Char = text[i]
        if (symbol == breakChar || symbolsAfterNewLine == stringLengthLimit) {
            textOutput.append('\n')
            symbolsAfterNewLine = 1
        } else {
            symbolsAfterNewLine += 1
        }
    }
    return textOutput.toString()
}

fun solve() {
    val stringToChange: String = FileReader("./input.txt").readText()
    println(divideText(stringToChange, 60))
}
