package dev.schmetter.aoc2020

import dev.schmetter.aoc2020.util.Resources
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 15")
class Day16Test {

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            // Given
            val input = Resources.resourceAsStringSplitByNewline("examples/day16.txt","|")

            // When
            val answer = Day16(input).solvePart1()

            // Then
            assertThat(answer).isEqualTo(71)
        }

        @Test
        fun `Actual answer`() {
            // Given
            val input = Resources.resourceAsStringSplitByNewline("day16.txt","|")

            // When
            val answer = Day16(input).solvePart1()

            // Then
            assertThat(answer).isEqualTo(23115)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            // Given
            val input = Resources.resourceAsStringSplitByNewline("examples/day16.2.txt","|")

            // When
            val answer = Day16(input).solvePart2()

            // Then
            assertThat(answer).isEqualTo(132)
        }

        @Test
        fun `Actual answer`() {
            // Given
            val input = Resources.resourceAsStringSplitByNewline("day16.txt","|")

            // When
            val answer = Day16(input).solvePart2()

            // Then
            assertThat(answer).isEqualTo(323780)
        }
    }
}