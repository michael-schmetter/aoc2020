package dev.schmetter.aoc2020.util

import java.io.File
import java.net.URI

internal object Resources {
    fun resourceAsString(file: String, delim: String = ""): String =
            resourceAsList(file).reduce { a, b -> "$a$delim$b" }

    fun resourceAsList(file: String): List<String> =
            File(file.toURI()).readLines()

    fun resourceAsStringSplitByNewline(file: String, delim: String = ""): String =
        resourceAsText(file).split("\r\n\r\n").reduce { a, b -> "$a$delim$b" }

    fun resourceAsText(file: String): String =
        File(file.toURI()).readText()

    private fun String.toURI(): URI =
            Resources.javaClass.classLoader.getResource(this)?.toURI()
                    ?: throw IllegalArgumentException("Cannot find Resource: $this")
}