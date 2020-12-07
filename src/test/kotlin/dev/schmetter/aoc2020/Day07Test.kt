package dev.schmetter.aoc2020

import dev.schmetter.aoc2020.util.Resources
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 07")
class Day07Test {

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            // Given
            val input = Resources.resourceAsString("examples/day7.txt","|")

            // When
            val answer = Day07(input).solvePart1()

            // Then
            assertThat(answer).isEqualTo(4)
        }

        @Test
        fun `Actual answer`() {
            // Given
            val input = Resources.resourceAsString("day7.txt","|")

            // When
            val answer = Day07(input).solvePart1()

            // Then
            assertThat(answer).isEqualTo(265)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            // Given
            val input = Resources.resourceAsString("examples/day7.2.txt","|")

            // When
            val answer = Day07(input).solvePart2()

            // Then
            assertThat(answer).isEqualTo(32)
        }

        @Test
        fun `Actual answer`() {
            // Given
            val input = Resources.resourceAsString("day7.txt","|")

            // When
            val answer = Day07(input).solvePart2()

            // Then
            assertThat(answer).isEqualTo(14177)
        }
    }
}