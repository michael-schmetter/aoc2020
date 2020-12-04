package dev.schmetter.aoc2020

import dev.schmetter.aoc2020.util.Resources
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 04")
class Day04Test {

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            // Given
            val input = Resources.resourceAsStringSplitByNewline("examples/day4.txt",",")

            // When
            val answer = Day04(input).solvePart1()

            // Then
            assertThat(answer).isEqualTo(8)
        }

        @Test
        fun `Actual answer`() {
            // Given
            val input = Resources.resourceAsStringSplitByNewline("day4.txt",",")

            // When
            val answer = Day04(input).solvePart1()

            // Then
            assertThat(answer).isEqualTo(245)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            // Given
            val input = Resources.resourceAsStringSplitByNewline("examples/day4.txt",",")

            // When
            val answer = Day04(input).solvePart2()

            // Then
            assertThat(answer).isEqualTo(4)
        }

        @Test
        fun `Actual answer`() {
            // Given
            val input = Resources.resourceAsStringSplitByNewline("day4.txt",",")

            // When
            val answer = Day04(input).solvePart2()

            // Then
            assertThat(answer).isEqualTo(133)
        }
    }
}