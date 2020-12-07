package dev.schmetter.aoc2020

import dev.schmetter.aoc2020.util.Resources
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 06")
class Day06Test {

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            // Given
            val input = Resources.resourceAsStringSplitByNewline("examples/day6.txt",",")

            // When
            val answer = Day06(input).solvePart1()

            // Then
            assertThat(answer).isEqualTo(1)
        }

        @Test
        fun `Actual answer`() {
            // Given
            val input = Resources.resourceAsStringSplitByNewline("day6.txt",",")

            // When
            val answer = Day06(input).solvePart1()

            // Then
            assertThat(answer).isEqualTo(6443)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            // Given
            val input = Resources.resourceAsStringSplitByNewline("examples/day6.txt",",")

            // When
            val answer = Day06(input).solvePart2()

            // Then
            assertThat(answer).isEqualTo(6)
        }

        @Test
        fun `Actual answer`() {
            // Given
            val input = Resources.resourceAsStringSplitByNewline("day6.txt",",")

            // When
            val answer = Day06(input).solvePart2()

            // Then
            assertThat(answer).isEqualTo(3232)
        }
    }
}