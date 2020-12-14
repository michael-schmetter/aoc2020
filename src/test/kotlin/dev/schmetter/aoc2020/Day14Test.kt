package dev.schmetter.aoc2020

import dev.schmetter.aoc2020.util.Resources
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 14")
class Day14Test {

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            // Given
            val input = Resources.resourceAsString("examples/day14.txt",",")

            // When
            val answer = Day14(input).solvePart1()

            // Then
            assertThat(answer).isEqualTo(165)
        }

        @Test
        fun `Actual answer`() {
            // Given
            val input = Resources.resourceAsString("day14.txt",",")

            // When
            val answer = Day14(input).solvePart1()

            // Then
            assertThat(answer).isEqualTo(17765746710228)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            // Given
            val input = Resources.resourceAsString("examples/day14.2.txt",",")

            // When
            val answer = Day14(input).solvePart2()

            // Then
            assertThat(answer).isEqualTo(208)
        }

        @Test
        fun `Actual answer`() {
            // Given
            val input = Resources.resourceAsString("day14.txt",",")

            // When
            val answer = Day14(input).solvePart2()

            // Then
            assertThat(answer).isEqualTo(4401465949086)
        }
    }
}